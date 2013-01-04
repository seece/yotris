package com.lofibucket.yotris.util;

import java.io.File;
import java.util.ArrayList;


public class FileDAO implements ScoreDAO, SettingsDAO {
	private String filepath;
	private ArrayList<ScoreEntry> scorelist;
	private File file;

	public FileDAO() {
		this("scores.dat");
	}	

	public FileDAO(String filepath) {
		 this.filepath = filepath;
		 this.scorelist = new ArrayList<>();
	}	

	public FileDAO(File file) {
		 this.scorelist = new ArrayList<>();
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
