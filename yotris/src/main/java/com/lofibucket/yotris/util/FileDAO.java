package com.lofibucket.yotris.util;

import java.io.File;
import java.io.FileNotFoundException;
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
				ScoreEntry entry = new ScoreEntry(line);
				scorelist.add(entry);
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
		return true;
	}

	@Override
	public boolean setContent(ArrayList<ScoreEntry> scorelist) {
		this.scorelist = scorelist;
		saveScorelist();
		return true;
	}

}
