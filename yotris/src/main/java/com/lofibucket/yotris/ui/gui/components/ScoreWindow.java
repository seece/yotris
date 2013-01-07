
package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.ui.gui.action.HideWindowActionListener;
import com.lofibucket.yotris.util.HighScores;
import com.lofibucket.yotris.util.ScoreEntry;
import com.lofibucket.yotris.util.Settings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ScoreWindow extends JFrame {
	private CommandContainer container;
	private Settings settings;
	private HighScores scores;
	private GameState state;

	public ScoreWindow(CommandContainer container, Settings settings, 
			GameState state) {
		super("Scores");

		this.container = container;
		this.settings = settings;
		this.state = state;

		setPreferredSize(new Dimension(400, 300));
		setResizable(false);

		//NameDialog dialog = new NameDialog(this);

		scores = new HighScores();
		checkScore();
		createComponents();
		
		pack();

	}

	// TODO move this to HighScores
	private void checkScore() {
		if (state == null) {
			System.out.println("null");
			return;
		}

		if (!scores.isHighScore(state.score)) {
			return;
		}

		Object response = JOptionPane.showInputDialog("A new highscore! Please enter your name:");
		String name = (String)response;
		System.out.println("name: " + name);

		scores.insertScoreEntry(name, state.score);
	}

	private void createComponents() {
		JPanel pane = new JPanel();
		this.add(pane);
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("Hall of Fame");
		title.setFont(new Font("arial", Font.BOLD, 16));
		pane.add(title);

		List<ScoreEntry> top = scores.getTopTen();

		for (int i=0;i<top.size();i++) {
			ScoreEntry entry = top.get(i);
			System.out.println(i + ": " + entry.toString());
			JLabel label = new JLabel((i+1) + ".  " + entry.getName() + 
					": " + entry.getScore());
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			pane.add(label);
		}
		
		JButton nappu = new JButton("Close");

		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		nappu.setAlignmentX(Component.CENTER_ALIGNMENT);


		pane.add(Box.createVerticalGlue());
		pane.add(nappu);

		nappu.addActionListener(new HideWindowActionListener(this));
	}
}

