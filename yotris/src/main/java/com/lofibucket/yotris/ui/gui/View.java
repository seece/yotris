/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lofibucket.yotris.ui.gui;

import com.lofibucket.yotris.logic.GameState;

/**
 *	A view that is used visually represent data to user.
 */

public interface View {
	/**
	 * Updates the View with new data.
	 * @param state the current game state
	 */
	public void updateState(GameState state);
}
