package com.lofibucket.yotris.ui;

import com.lofibucket.yotris.util.commands.Command;
import java.util.Observable;
import com.lofibucket.yotris.logic.GameState;
import com.lofibucket.yotris.util.commands.NoneCommand;
import java.util.ArrayList;

public class GUI implements UserInterface {

	private ArrayList<Command> commandlist;

	public GUI() {
		commandlist = new ArrayList<>();
	}

	
	@Override
	public void update(Observable obs, Object arg) {
		GameState state = (GameState)arg;
	}

	@Override
	public ArrayList<Command> getNewCommands() {

		commandlist.add(new NoneCommand());

		return commandlist;
	}
	
}
