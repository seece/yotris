package com.lofibucket.yotris.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Takes care of file access.
 */
public class FileDAO implements ScoreDAO, SettingsDAO {
	private String filepath;
	private ArrayList<ScoreEntry> scorelist;
	private File file;

	public FileDAO() {
		this("scores.dat");
	}	

	public FileDAO(String filepath) {
		 this(new File(filepath));
		 this.filepath = filepath;
	}	

	public FileDAO(File file) {
		 this.file = file;
		 reloadScoreList();
	}	

	/**
	 * Reloads the score list from file. Mainly used in tests, because in
	 * normal usage the scores are accessed only through this DAO.
	 */
	protected void reloadScoreList() {
		 try {
			 this.scorelist = loadScoreList();
		 } catch (FileNotFoundException e) {
			// file not found, so we'll create it when saving
			this.scorelist = new ArrayList<>();
		 }
	}

	private ArrayList<ScoreEntry> loadScoreList() throws FileNotFoundException {
		ArrayList<ScoreEntry> scores = new ArrayList<>();

		try (Scanner reader = new Scanner(file, "UTF-8")) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (line.isEmpty()) {
					continue;
				}

				ScoreEntry entry = new ScoreEntry(line);
				scores.add(entry);
			}
		}
		
		return scores;
	}

	@Override
	public ArrayList<ScoreEntry> getScorelist() {
		return scorelist;
	}

	@Override
	public boolean saveScorelist() {
		OutputStreamWriter testwriter;
		
		try {
			testwriter = new OutputStreamWriter(new FileOutputStream(file),
					 Charset.forName("UTF-8").newEncoder());
			writeContent(testwriter);
			testwriter.flush();
		} catch (IOException ex) {
			return false;
		}

		try {
			testwriter.close();
		} catch (IOException ex) {
			return false;
		}

		return true;
	}

	private void writeContent(OutputStreamWriter writer) throws IOException {
		for (ScoreEntry e : scorelist) {
			writer.write(e.toString());
			writer.write("\n");
		}
	}

	@Override
	public boolean setContent(ArrayList<ScoreEntry> scorelist) {
		this.scorelist = scorelist;
		saveScorelist();
		return true;
	}

}
