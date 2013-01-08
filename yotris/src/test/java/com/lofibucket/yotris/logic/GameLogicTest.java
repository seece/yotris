
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
	}

	@Test
	public void testFrameCounterIncrement() {
		logic.reset(settings);
		logic.update(ui.pollCommands());
		assertEquals(1, logic.getSimulatedFrames());
	}
	
	@Test
	public void testFrameCounterZeroAtInit() {
		logic.reset(settings);
		assertEquals(0, logic.getSimulatedFrames());
	}

	@Test
	public void testCommandGetsApplied() {
		ArrayList<Integer> testlist = new ArrayList<>();
		testlist.add(1);

		logic.reset(settings);
		ui.addNewCommand(new MockCommand(testlist));
		logic.update(ui.pollCommands());

		assertEquals(2, testlist.size());
	}

	@Test
	public void testObserverUpdateGetsCalled() {
		logic.reset(settings);
		logic.update(ui.pollCommands());
		assertTrue(ui.updated > 0);
	}

	@Test
	public void testScoreIncreasesWhenClearingLine() {
		logic.reset(settings);
		int startscore = logic.getGameState().score;
		logic.increaseScore(4);
		assertTrue(logic.getGameState().score > startscore);
	}

	@Test
	public void testScoreIncreasesWhenBlockHitsBottom() {
		logic.reset(settings);
		int startscore = logic.getGameState().score;
		logic.increaseScoreHitBottom();
		assertTrue(logic.getGameState().score > startscore);
	}

	@Test
	public void testLevelIncreasesWithScore() {
		logic.reset(settings);
		logic.increaseScore(100);
		assertTrue(logic.getLevel() > 1);
	}
}

class MockCommand extends Command {
	private ArrayList<Integer> list;

	public MockCommand(ArrayList<Integer> list) {
		this.list = list;
	}

	@Override
	public void apply(GameLogic logic) {
		this.list.add(2);
	}


}