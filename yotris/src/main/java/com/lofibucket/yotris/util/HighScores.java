package com.lofibucket.yotris.util;

import com.lofibucket.yotris.util.FileDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScores {
	private ArrayList<ScoreEntry> scorelist;
	private FileDAO dao;

	public HighScores() {
		this.dao = new FileDAO();
		this.scorelist = dao.getScorelist();
	}

	public List<ScoreEntry> getTopTen() {
		List<ScoreEntry> topten;

		Collections.sort(scorelist);	
		topten = scorelist.subList(0, 9);
		
		return topten;
	}

	public boolean insertScoreEntry(String name, int score) {
		ScoreEntry entry = new ScoreEntry(name, score);

		Collections.sort(scorelist);
		if (scorelist.get(9).getScore() < entry.getScore()) {
			scorelist.add(entry);
			return true;
		}
		
		return false;
	}
}
