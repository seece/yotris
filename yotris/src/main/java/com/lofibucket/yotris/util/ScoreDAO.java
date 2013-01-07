
package com.lofibucket.yotris.util;

import java.util.ArrayList;
import java.util.List;

/**
 * High score table storage object interface.
 */
public interface ScoreDAO {
	public List<ScoreEntry> getScorelist();
	public boolean saveScorelist();
	public boolean setContent(List<ScoreEntry> scorelist);
}
