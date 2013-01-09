
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.ui.gui.View;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The status bar component visible in the upper part of the main window.
 */
public class StatusBar extends JPanel implements View {
	private JLabel score;
	private JLabel paused;
	private JLabel level;

	private String msgScore = "Score: ";
	private String msgLevel = "Level: ";
	private String msgPaused = "     Game paused";
	private String msgNotPaused = "";

	/**
	 * Constructor.
	 * @param layout 	the layout manager to use
	 */
	public StatusBar(LayoutManager layout) {
		super(layout);

		createComponents();
	}

	/**
	 * Creates a status bar with BorderLayout.
	 */
	public StatusBar() {
		this(new BorderLayout());
	}

	/**
	 * Creates all components.
	 */
	private void createComponents() {
		score = new JLabel("");
		paused = new JLabel("");
		level = new JLabel("");
		this.add(score, BorderLayout.LINE_START);
		this.add(paused, BorderLayout.CENTER);
		this.add(level, BorderLayout.LINE_END);
	}

	/**
	 * Updates the score view.
	 * @param scoreAmount 	the new score
	 */
	private void updateScore(int scoreAmount) {
		score.setText(msgScore + scoreAmount);
	}

	/**
	 * Updates the pause state text.
	 * @param state 	the current state of the game
	 */
	private void updatePaused(GameState state) {
		if (state.paused) {
			paused.setText(msgPaused);
		} else {
			paused.setText(msgNotPaused);
		}

	}

	@Override
	public void updateState(GameState state) {
		updateScore(state.score);
		level.setText(msgLevel + state.level);
		updatePaused(state);

		this.repaint();
	}

}
