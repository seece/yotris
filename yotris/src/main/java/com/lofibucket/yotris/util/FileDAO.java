package com.lofibucket.yotris.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Takes care of file access.
 */
public class FileDAO implements ScoreDAO {
	private String filepath;
	private List<ScoreEntry> scorelist;
	private File file;

	/**
	 * Initializes the Data Access Object with the default file path.
	 */
	public FileDAO() {
		this("scores.dat");
	}	

	/**
	 * Constructor with a custom file path. (Used mainly for testing purposes.)
	 * @param filepath custom file path to use
	 */
	public FileDAO(String filepath) {
		 this(new File(filepath));
		 this.filepath = filepath;
	}	

	/**
	 * Constructor with a predefined file. Used mainly for testing purposes.
	 * @param file file to use for file access.
	 */
	public FileDAO(File file) {
		 this.file = file;
		 reloadScoreList();
	}	

	/**
	 * Reloads the score list from file. Mainly used in tests, because in
	 * normal usage the scores are accessed only through this DAO.
	 */
	final protected void reloadScoreList() {
		 try {
			 this.scorelist = loadScoreList();
		 } catch (FileNotFoundException e) {
			// file not found, so we'll create it when saving
			this.scorelist = new ArrayList<>();
		 }
	}

	/**
	 * Loads the score list from file.
	 * @return	all score entries loaded in the file
	 * @throws FileNotFoundException 
	 */
	private List<ScoreEntry> loadScoreList() throws FileNotFoundException {
		List<ScoreEntry> scores = new ArrayList<>();

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
	public List<ScoreEntry> getScorelist() {
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

	/**
	 * Writes the contents of the currently loaded score list to the given
	 * OutputStreamWriter.
	 * @param writer	the writer to use
	 * @throws IOException 
	 */
	private void writeContent(OutputStreamWriter writer) throws IOException {
		for (ScoreEntry e : scorelist) {
			writer.write(e.toString());
			writer.write("\n");
		}
	}

	@Override
	public void setContent(List<ScoreEntry> scorelist) {
		this.scorelist = scorelist;
		saveScorelist();
	}

}
