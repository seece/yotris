
package yotris;
import yotris.logic.GameLogic;
import yotris.logic.GameState;
import yotris.ui.UserInterface;
import yotris.ui.GUI;

public class Yotris {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		UserInterface ui = new GUI();
		GameLogic logic = new GameLogic(ui);
		GameState state;

		do {

			state = logic.update();

		} while (state.running);
	}
}
