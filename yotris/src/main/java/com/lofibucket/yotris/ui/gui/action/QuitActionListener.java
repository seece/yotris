
package com.lofibucket.yotris.ui.gui.action;

import com.lofibucket.yotris.ui.CommandContainer;
import com.lofibucket.yotris.util.commands.QuitCommand;
import java.awt.event.ActionEvent;


public class QuitActionListener extends CommandActionListener {

	public QuitActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		container.addNewCommand(new QuitCommand());
	}

}
