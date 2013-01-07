
package com.lofibucket.yotris.util;

/**
 * An entry in a high score table.
 */
public class ScoreEntry implements Comparable<ScoreEntry> {
	private String name;
	private int score;

	public ScoreEntry(String line) {
		String[] words = line.split("\t");
		parseLine(words);
	}

	private void parseLine(String[] words) {
		// we assume this line DOES have two columns
		this.name = words[0];
		this.score = Integer.parseInt(words[1]);
	}

	public ScoreEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

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

	@Override
	public String toString() {
		return this.name + "\t" + this.score;	
	}
	
}
