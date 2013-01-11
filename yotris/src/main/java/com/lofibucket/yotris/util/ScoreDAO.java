
package com.lofibucket.yotris.util;

import java.util.List;

/**
 * High score table storage object interface.
 */
public interface ScoreDAO {
	/**
	 * Returns the loaded score list.
	 * @return list of score entries
	 */
	public List<ScoreEntry> getScorelist();
	/**
	 * Saves the currently loaded list to a file.
	 * @return true if the list was saved successfully, otherwise false
	 */
	public boolean saveScorelist();
	/**
	 * Replaces the HighScore container content, and saves to the disk.
	 * @param scorelist	the new content to use
	 */
	public void setContent(List<ScoreEntry> scorelist);
}
