
package com.lofibucket.yotris.ui.gui.menu;

import com.lofibucket.yotris.ui.CommandContainer;
import java.awt.event.ActionEvent;


public class QuitActionListener extends CommandActionListener {

	public QuitActionListener(CommandContainer container) {
		super(container);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("the game should end now");		
		// container.add(new QuitCommand());
	}

}
