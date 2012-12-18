package yotris.util;

import java.util.ArrayList;


public class ScoreDAO {
	private String filepath;
	private ArrayList<ScoreEntry> scorelist;

	public ScoreDAO() {
		this("data/scores.dat");
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



}
