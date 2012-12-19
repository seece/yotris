package com.lofibucket.yotris.util;

import java.util.ArrayList;


public class ScoreDAO {
	private String filepath;
	private ArrayList<ScoreEntry> scorelist;

	public ScoreDAO() {
		this("scores.dat");
	}	

	public ScoreDAO(String filepath) {
		 this.filepath = filepath;
		 this.scorelist = new ArrayList<>();
	}	

	public ArrayList<ScoreEntry> getScorelist() {
		return scorelist;
	}

	public boolean saveScorelist() {
		return true;
	}

	public boolean setContent(ArrayList<ScoreEntry> scorelist) {
		this.scorelist = scorelist;
		saveScorelist();
		return true;
	}


}
