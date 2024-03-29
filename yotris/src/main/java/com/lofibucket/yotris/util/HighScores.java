package com.lofibucket.yotris.util;

import java.util.Collections;
import java.util.List;

/**
 * A class for manipulating and storing the high score table.
 */
public class HighScores {
	/**
	 * The list of scores acquired from the DAO.
	 */
	private List<ScoreEntry> scorelist;
	/**
	 * Takes care of file access & sorting when saving/loading scores.
	 */
	private FileDAO dao;

	/**
	 * Constructor with the default DAO.
	 */
	public HighScores() {
		this.dao = new FileDAO();
		this.scorelist = dao.getScorelist();
	}

	/**
	 * Constructor with custom DAO.
	 * @param dao the data access object to use
	 */
	public HighScores(FileDAO dao) {
		this.dao = dao;
		this.scorelist = dao.getScorelist();
	}

	/**
	 * Returns the ten best (highest scoring) ScoreEntries.
	 * @return list of ten best ScoreEntries
	 */
	public List<ScoreEntry> getTopTen() {
		List<ScoreEntry> topten;

		Collections.sort(scorelist);	
		topten = scorelist.subList(0, (int)Math.min(scorelist.size(), 10));
		
		return topten;
	}

	/**
	 * Inserts a score entry to the list, if the score is high enough.
	 * @param name	player name
	 * @param score	player score
	 * @return true if added, otherwise false
	 */
	public boolean insertScoreEntry(String name, int score) {
		ScoreEntry entry = new ScoreEntry(sanitizeInput(name), score);

		List<ScoreEntry> top = getTopTen();

		if (isHighScore(score)) {
			scorelist.add(entry);
			dao.saveScorelist();
			return true;
		}
		
		return false;
	}

	/**
	 * Removes excess whitespace from string.
	 * @param input	the input from user
	 * @return 	a sanitized string
	 */
	protected String sanitizeInput(String input) {
		String trimmed = input.trim();
		trimmed= trimmed.replaceAll("\t", "");
		return trimmed;
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
