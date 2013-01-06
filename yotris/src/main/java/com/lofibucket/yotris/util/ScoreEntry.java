
package com.lofibucket.yotris.util;

public class ScoreEntry implements Comparable<ScoreEntry> {
	private String name;
	private int score;

	public ScoreEntry(String line) {
		System.out.println("line: " + line);
		String[] words = line.split("\t");
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
		if (this.score < entry.getScore()) {
			return -1;
		}

		if (this.score > entry.getScore()) {
			return 1;
		}

		return 0;
	}
	
}
