
package yotris;
import com.lofibucket.yotris.logic.Game;
import com.lofibucket.yotris.ui.GUI;
import com.lofibucket.yotris.ui.UserInterface;

public class Yotris {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		UserInterface ui = new GUI();
		Game game = new Game(ui);
		game.run();
	}
}
