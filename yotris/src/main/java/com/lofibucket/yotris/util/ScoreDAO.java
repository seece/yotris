
package com.lofibucket.yotris.util;

import java.util.ArrayList;

public interface ScoreDAO {
	public ArrayList<ScoreEntry> getScorelist();
	public boolean saveScorelist();
	public boolean setContent(ArrayList<ScoreEntry> scorelist);
}
