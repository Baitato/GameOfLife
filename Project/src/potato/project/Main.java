package potato.project;

import javax.swing.SwingUtilities;

public class Main implements Runnable {
	
	@Override
	public void run() {
		new Window("Game of life", 968, 968);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Main());
	}
}
