
package com.lofibucket.yotris.util;

import java.util.ArrayList;

/**
 * High score table storage object interface.
 */
public interface ScoreDAO {
	public ArrayList<ScoreEntry> getScorelist();
	public boolean saveScorelist();
	public boolean setContent(ArrayList<ScoreEntry> scorelist);
}
