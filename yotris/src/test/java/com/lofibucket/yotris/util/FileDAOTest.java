
package yotris.util;

import com.lofibucket.yotris.util.ScoreEntry;
import com.lofibucket.yotris.util.FileDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class FileDAOTest {
	public static final String filepath = "testscores.dat";
	public FileDAO dao;
	public ArrayList<ScoreEntry> mockdata;

	public FileDAOTest() {
		mockdata = new ArrayList<>();
		mockdata.add(new ScoreEntry("kaapo", 100));
		mockdata.add(new ScoreEntry("miika", 200));
		mockdata.add(new ScoreEntry("anneli", 50));
		mockdata.add(new ScoreEntry("kirsi", 350));
		mockdata.add(new ScoreEntry("kirsi", 450));

		dao = new FileDAO(filepath);
	}

	public void writeMockData(FileWriter writer) throws IOException {
		for (ScoreEntry e : mockdata) {
			writer.write(e.getName() + " " + Integer.toString(e.getScore()));
		}
	}

	public boolean setupTestData() {
		FileWriter testwriter;
		
		try {
			testwriter = new FileWriter(filepath);
			writeMockData(testwriter);
		} catch (IOException ex) {
			return false;
		}

		try {
			testwriter.close();
		} catch (IOException ex) {
			return false;
		}

		return true;
	}

	public void checkSize(ArrayList<ScoreEntry> list) {
		assertEquals(mockdata.size(), list.size());
	}

	@Before
	public void setupDAO() {
		assertTrue(setupTestData());
	}

	@Test
	public void scoreListAmount() {
		ArrayList<ScoreEntry> scorelist = dao.getScorelist();
		
		checkSize(scorelist);
	}

	@Test
	public void scoreListOrder() {
		ArrayList<ScoreEntry> scorelist = dao.getScorelist();

		checkSize(scorelist);
		
		assertEquals(scorelist.get(0).getName(), mockdata.get(0).getName());
		assertEquals(scorelist.get(4).getName(), mockdata.get(4).getName());
	}

	@Test
	public void scoreListScores() {
		ArrayList<ScoreEntry> scorelist = dao.getScorelist();

		checkSize(scorelist);
		
		assertEquals(scorelist.get(0).getScore(), mockdata.get(0).getScore());
		assertEquals(scorelist.get(4).getScore(), mockdata.get(4).getScore());
	}

	@Test
	public void scoresAndNamesCombined() {
		ArrayList<ScoreEntry> scorelist = dao.getScorelist();
		
		checkSize(scorelist);

		for (int i=0;i<mockdata.size();i++) {
			assertEquals(scorelist.get(i).getScore(), mockdata.get(i).getScore());
			assertEquals(scorelist.get(i).getName(), mockdata.get(i).getName());
		}
	}
}
