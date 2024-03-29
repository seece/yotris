package com.lofibucket.yotris.ui.gui.components;

import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.ui.gui.View;
import com.lofibucket.yotris.ui.gui.action.NewGameActionListener;
import com.lofibucket.yotris.ui.gui.action.PauseActionListener;
import com.lofibucket.yotris.ui.gui.action.QuitActionListener;
import com.lofibucket.yotris.ui.gui.action.ShowWindowActionListener;
import com.lofibucket.yotris.util.Settings;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 * The main window class.
 */
public class MainWindow extends JFrame implements View {

	private JMenuBar menubar;
	private JMenu gameMenu;
	private JMenu viewMenu;
	private GameArea area;
	private CommandContainer commandlist;
	private StatusBar statusbar;
	private ScoreWindow scoreWindow; 
	private AboutWindow aboutWindow; 
	private Settings settings;
	private GameState lastState;
	private boolean scoresShown;

	/**
	 * The main window constructor.
	 * @param settings	current game settings
	 * @param commandlist 	the command container to new commands into
	 */
	public MainWindow(Settings settings, CommandContainer commandlist) {
		super("yotris " + settings.getVersion().toString());

		this.settings = settings;
		this.commandlist = commandlist;

		scoreWindow = new ScoreWindow(commandlist, settings);
		aboutWindow = new AboutWindow(settings);

		setPreferredSize(new Dimension(330, 552));
		setResizable(false);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(getContentPane());
		createMenu();
	}

	/**
	 * Creates all window components.
	 * @param container the container to add all the created components
	 */
	private void createComponents(Container container) {
		//container.addKeyListener(keylistener);
		area = new GameArea(null, settings.getTheme());
		container.add(area, BorderLayout.CENTER);

		statusbar = new StatusBar();

		container.add(statusbar, BorderLayout.NORTH);
	}

	/**
	 * Creates all the menus for the main window.
	 */
	private void createMenu() {
		menubar = new JMenuBar();
		gameMenu = new JMenu("Game");
		viewMenu = new JMenu("View");

		menubar.add(gameMenu);
		menubar.add(viewMenu);

		JMenuItem startItem = new JMenuItem("New game");
		JMenuItem pauseItem = new JMenuItem("Toggle pause");
		JMenuItem quitItem = new JMenuItem("Quit");

		startItem.getAccessibleContext().setAccessibleDescription(
				"Start a new game");
		startItem.setMnemonic(KeyEvent.VK_N);
		quitItem.setMnemonic(KeyEvent.VK_Q);

		startItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, ActionEvent.ALT_MASK));
		pauseItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_P, ActionEvent.ALT_MASK));
		quitItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_Q, ActionEvent.ALT_MASK));

		gameMenu.add(startItem);
		gameMenu.add(pauseItem);
		gameMenu.add(quitItem);

		JMenuItem hallOfFameItem 	= new JMenuItem("Hall of Fame");
		JMenuItem aboutItem			= new JMenuItem("About yotris");
		viewMenu.add(hallOfFameItem);
		viewMenu.add(aboutItem);

		startItem.addActionListener(new NewGameActionListener(commandlist));
		pauseItem.addActionListener(new PauseActionListener(commandlist));
		quitItem.addActionListener(new QuitActionListener(commandlist));
		hallOfFameItem.addActionListener(new ShowWindowActionListener(scoreWindow));
		aboutItem.addActionListener(new ShowWindowActionListener(aboutWindow));

		this.setJMenuBar(menubar);
	}

	@Override
	public void updateState(GameState state) {
		area.setRenderGrid(state.getRenderGrid());
		area.repaint();
		statusbar.updateState(state);

		updateGameoverScreen(state);
		lastState = new GameState(state);
	}

	/**
	 * If the game just ended, this shows the game over (hall of fame) screen.
	 * @param state 	current game state
	 */
	private void updateGameoverScreen(GameState state) {
		if (gameJustEnded(state)) {
			scoreWindow = new ScoreWindow(commandlist, settings, state);
			scoreWindow.setVisible(true);
			scoresShown = true;
		}
	}

	/**
	 * Deduces if the player just lost the game.
	 * @param currentState	current state of the game passed in from the game
	 * logic
	 * @return 	true if the game was just lost, otherwise false
	 */
	private boolean gameJustEnded(GameState currentState) {
		if (currentState == null) {
			return false;
		}

		if (!currentState.gameover) {
			return false;
		}

		if (lastState == null || !lastState.gameover) {
			return true;
		}

		return false;
	}

	/**
	 * Clears the score window.
	 */
	public void reset() {
		if (settings.debugEnabled()) {
			System.out.println("RESET");
		}

		scoreWindow = null;
		scoresShown = false;
	}
}
