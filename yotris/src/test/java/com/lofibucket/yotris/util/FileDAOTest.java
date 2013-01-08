
package com.lofibucket.yotris.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class FileDAOTest {
	public static final String readpath = "testscores.dat";
	public static final String writepath = "testscoresx.dat";
	public FileDAO dao;
	public ArrayList<ScoreEntry> mockdata;
	public File file;

	public FileDAOTest() {
		mockdata = new ArrayList<>();
		mockdata.add(new ScoreEntry("kaapo", 100));
		mockdata.add(new ScoreEntry("miika", 200));
		mockdata.add(new ScoreEntry("anneli", 50));
		mockdata.add(new ScoreEntry("kirsi", 350));
		mockdata.add(new ScoreEntry("kirsi", 450));

		file = new File(readpath);
		dao = new FileDAO(file);
		//dao.setContent(mockdata);
	}

	public void writeMockData(OutputStreamWriter writer) throws IOException {
		for (ScoreEntry e : mockdata) {
			writer.write(e.getName() + "\t" + Integer.toString(e.getScore()));
			writer.write("\n");
		}

	}

	private void readLines(File file) throws FileNotFoundException {
		int row = 1;
		try (Scanner reader = new Scanner(file, "UTF-8")) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				//System.out.println(row + ": " + line);
				row++;
			}
		}
	}

	public boolean setupTestData() {
		OutputStreamWriter testwriter;
		
		try {
			testwriter = new OutputStreamWriter(new FileOutputStream(readpath),
					 Charset.forName("UTF-8").newEncoder());
			writeMockData(testwriter);
			testwriter.flush();
		} catch (IOException ex) {
			return false;
		}

		try {
			testwriter.close();
		} catch (IOException ex) {
			return false;
		}

		/*
		try {
			readLines(new File(readpath));
		} catch (FileNotFoundException ex) {

		}
		*/
		
		return true;
	}

	public void checkSize(List<ScoreEntry> list) {
		assertEquals(mockdata.size(), list.size());
	}

	@Before
	public void setupDAO() {
		setupTestData();
		dao.reloadScoreList();
	}

	@Test
	public void testScoreListSaving() {
		File writefile = new File(writepath);
		writefile.delete();
		FileDAO fdao = new FileDAO(writefile);
		fdao.setContent(mockdata);
		fdao.saveScorelist();
		
		int row = 0;

		try {
			try (Scanner reader = new Scanner(new File(writepath), "UTF-8")) {
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					if (line.isEmpty()) {
						continue;
					}

					ScoreEntry entry = new ScoreEntry(line);
					assertEquals(mockdata.get(row).toString(),
							entry.toString());
					row++;
				}
			}
		} catch (Exception ex) {

		}
		
	}

	@Test
	public void testScoreListLoadingAmount() {
		List<ScoreEntry> scorelist = dao.getScorelist();
		
		checkSize(scorelist);
	}

	@Test
	public void testScoreListLoadingOrder() {
		List<ScoreEntry> scorelist = dao.getScorelist();

		assertEquals(scorelist.get(0).getName(), mockdata.get(0).getName());
		assertEquals(scorelist.get(4).getName(), mockdata.get(4).getName());
	}

	@Test
	public void testScoreListLoadingScores() {
		List<ScoreEntry> scorelist = dao.getScorelist();

		checkSize(scorelist);
		
		assertEquals(scorelist.get(0).getScore(), mockdata.get(0).getScore());
		assertEquals(scorelist.get(4).getScore(), mockdata.get(4).getScore());
	}

	@Test
	public void testLoadingScoresAndNamesCombined() {
		List<ScoreEntry> scorelist = dao.getScorelist();
		
		checkSize(scorelist);

		for (int i=0;i<mockdata.size();i++) {
			assertEquals(scorelist.get(i).getScore(), mockdata.get(i).getScore());
			assertEquals(scorelist.get(i).getName(), mockdata.get(i).getName());
		}
	}
}
