package com.lofibucket.yotris.util;

import com.lofibucket.yotris.util.FileDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class for manipulating and storing the high score table.
 */
public class HighScores {
	private List<ScoreEntry> scorelist;
	private FileDAO dao;

	public HighScores() {
		this.dao = new FileDAO();
		this.scorelist = dao.getScorelist();
	}

	public HighScores(FileDAO dao) {
		this.dao = dao;
		this.scorelist = dao.getScorelist();
	}

	public List<ScoreEntry> getTopTen() {
		List<ScoreEntry> topten;

		Collections.sort(scorelist);	
		topten = scorelist.subList(0, (int)Math.min(scorelist.size(), 10));
		
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

	/**
	 * Checks if the given score is high enough to be included in the hall of 
	 * fame.
	 * @param score the score to check
	 * @return true if the score is high enough, otherwise false
	 */
	public boolean isHighScore(int score) {
		List<ScoreEntry> list = getTopTen();

		if (list.size() < 10) {
			return true;
		}

		if (list.get(9).getScore() < score) {
			return true;	
		}

		return false;
	}
}
