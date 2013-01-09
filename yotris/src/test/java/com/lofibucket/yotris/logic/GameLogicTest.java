
package com.lofibucket.yotris.logic;

import com.lofibucket.yotris.ui.UserInterfaceMock;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;
import com.lofibucket.yotris.util.command.Command;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GameLogicTest {

	UserInterfaceMock ui;
	GameLogic logic;
	Settings settings;

    public GameLogicTest() {
    }

	@Before
	public void initLogic() {
		ui = new UserInterfaceMock();
		settings = new Settings();
		logic = new GameLogic(ui, settings);
		logic.reset(settings);
	}

	@Test
	public void testFrameCounterIncrement() {
		logic.update(ui.pollCommands());
		assertEquals(1, logic.getSimulatedFrames());
	}
	
	@Test
	public void testFrameCounterZeroAtInit() {
		assertEquals(0, logic.getSimulatedFrames());
	}

	@Test
	public void testCommandGetsApplied() {
		ArrayList<Integer> testlist = new ArrayList<>();
		testlist.add(1);

		ui.addNewCommand(new MockCommand(testlist));
		logic.update(ui.pollCommands());

		assertEquals(2, testlist.size());
	}

	@Test
	public void testCommandGetsAppliedGameoverOverride() {
		ArrayList<Integer> testlist = new ArrayList<>();
		testlist.add(1);

		MockCommand command = new MockCommand(testlist);
		command.overrideGameover = true;
		logic.endGame();
		ui.addNewCommand(command);
		logic.update(ui.pollCommands());

		assertEquals(2, testlist.size());
	}

	@Test
	public void testCommandGetsAppliedPauseOverride() {
		ArrayList<Integer> testlist = new ArrayList<>();
		testlist.add(1);

		MockCommand command = new MockCommand(testlist);
		command.overridePause = true;
		logic.pauseGame();

		ui.addNewCommand(command);
		logic.update(ui.pollCommands());

		assertEquals(2, testlist.size());
	}

	@Test
	public void testObserverUpdateGetsCalled() {
		logic.update(ui.pollCommands());
		assertTrue(ui.updated > 0);
	}

	@Test
	public void testScoreIncreasesWhenClearingLine() {
		int startscore = logic.getGameState().score;
		logic.increaseScore(4);
		assertTrue(logic.getGameState().score > startscore);
	}

	@Test
	public void testScoreIncreasesWhenBlockHitsBottom() {
		int startscore = logic.getGameState().score;
		logic.increaseScoreHitBottom();
		assertTrue(logic.getGameState().score > startscore);
	}

	@Test
	public void testLevelIncreasesWithScore() {
		logic.increaseScore(100);
		assertTrue(logic.getLevel() > 1);
	}

	@Test
	public void testQuitGameWorks() {
		logic.quitGame();
		assertEquals(false, logic.getGameState().running);
	}

	@Test
	public void testEndGameWorks() {
		logic.endGame();
		assertEquals(true, logic.getGameState().gameover);
	}

	@Test
	public void pauseGameWorks() {
		logic.pauseGame();
		assertEquals(true, logic.getGameState().paused);
	}
}

class MockCommand extends Command {
	private ArrayList<Integer> list;
	public boolean overridePause = false;
	public boolean overrideGameover = false;

	public MockCommand(ArrayList<Integer> list) {
		this.list = list;
	}

	@Override
	public void apply(GameLogic logic) {
		this.list.add(2);
	}

	@Override
	public boolean overridePause() {
		return overridePause;
	}

	@Override
	public boolean overrideGameOver() {
		return overrideGameover;
	}

	


}