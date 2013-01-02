
package yotris;
import com.lofibucket.yotris.logic.Game;
import com.lofibucket.yotris.ui.gui.GUI;
import com.lofibucket.yotris.ui.UserInterface;
import com.lofibucket.yotris.util.Settings;

public class Yotris {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
		System.exit(0);
	}
}
