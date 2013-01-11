
package com.lofibucket.yotris.util;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoresTest {
	FileDAO dao;
	HighScores scores;

	private ArrayList<ScoreEntry> getMockData() {
		ArrayList<ScoreEntry> arr = new ArrayList<>();
		for (int i=0;i<12;i++) {
			arr.add(new ScoreEntry("name " + i, (i * 119) % 1017));
		}
		return arr;
	}

    public HighScoresTest() {
		List<ScoreEntry> content = getMockData();
		dao = new FileDAOMock(content);
		scores = new HighScores(dao);
    }

	@Test
	public void testTopTenAmount() {
		assertTrue(scores.getTopTen().size() <= 10);
	}

	@Test
	public void testTopTenOrder() {
		List<ScoreEntry> list = scores.getTopTen();

		for (int i=0;i<list.size()-2;i++) {
			assertTrue(list.get(i).getScore() > list.get(i + 1).getScore());
		}
	}

	@Test
	public void sanitizeInputTrims() {
		assertEquals("nimi", scores.sanitizeInput("  nimi  "));
	}

	@Test
	public void sanitizeInputRemovesTabs() {
		assertEquals("nimi20", scores.sanitizeInput("nimi\t20"));
	}
}

class FileDAOMock extends FileDAO {

	private List<ScoreEntry> content;
	
	public FileDAOMock(List<ScoreEntry> content) {
		super();
		this.content = content;
	}

	@Override
	public List<ScoreEntry> getScorelist() {
		return content;
	}

	@Override
	public boolean saveScorelist() {
		return true;
	}
	
}