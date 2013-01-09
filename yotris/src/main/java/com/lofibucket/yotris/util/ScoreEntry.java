
package com.lofibucket.yotris.util;

/**
 * An entry in a high score table.
 */
public class ScoreEntry implements Comparable<ScoreEntry> {
	/**
	 * Name of the player.
	 */
	private String name;
	/**
	 * The score of this player.
	 */
	private int score;

	/**
	 * ScoreEntry constructor.
	 * @param line 	a line containing name and score separated by a tab
	 * character.
	 */
	public ScoreEntry(String line) {
		String[] words = line.split("\t");
		parseLine(words);
	}

	private void parseLine(String[] words) {
		// we assume this line DOES have two columns
		this.name = words[0];
		this.score = Integer.parseInt(words[1]);
	}

	/**
	 * Constructor that takes the fields as separate variables.
	 * @param name	name of the entrant
	 * @param score 	game score of this entrant
	 */
	public ScoreEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * Entrant name getter.
	 * @return entrant name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name setter.
	 * @param name the new name to use
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Entrant score getter.
	 * @return the score of the entrant
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Entrant score setter.
	 * @param score the new score to use	
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(ScoreEntry entry) {
		if (this.score > entry.getScore()) {
			return -1;
		}

		if (this.score < entry.getScore()) {
			return 1;
		}

		return 0;
	}

	/**
	 * 
	 * @return name and score as string, separated by a tab (\t) character
	 */
	@Override
	public String toString() {
		return this.name + "\t" + this.score;	
	}
	
}
