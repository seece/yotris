
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

}