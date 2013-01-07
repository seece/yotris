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
		topten = scorelist.subList(0, (int)Math.min(scorelist.size(), 9));
		
		return topten;
	}

	public boolean insertScoreEntry(String name, int score) {
		ScoreEntry entry = new ScoreEntry(name, score);

		List<ScoreEntry> top = getTopTen();
		if (top.size() < 10) {
			scorelist.add(entry);
			dao.saveScorelist();
			return true;
		}

		if (top.get(9).getScore() < entry.getScore()) {
			scorelist.add(entry);
			dao.saveScorelist();
			return true;
		}
		
		return false;
	}
}
