
package com.lofibucket.yotris.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ScoreEntryTest {
	private String name;
	private int score;
	private ScoreEntry entry;

    public ScoreEntryTest() {
    }

	@Before
	public void init() {
		name = "kaapo";
		score = 32;
		entry = new ScoreEntry(name + "\t" + score);
	}

	@Test
	public void testEntryLineNameIsParsedCorrectly() {
		assertEquals(name, entry.getName());
	}

	@Test
	public void testEntryLineScoreIsParsedCorrectly() {
		assertEquals(score, entry.getScore());
	}

	@Test
	public void testConstructorParametersAreSaved() {
		ScoreEntry entry2 = new ScoreEntry(name, score);
		assertEquals(name, entry2.getName());
		assertEquals(score, entry2.getScore());
	}
	
	@Test
	public void testToStringWorks() {
		ScoreEntry testEntry = new ScoreEntry(name, score);
		assertEquals(name + "\t" + score, testEntry.toString());
	}

}