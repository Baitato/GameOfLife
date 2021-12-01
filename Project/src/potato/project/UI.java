package potato.project;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class UI extends JPanel{
	private Game game;
	private int size;
		
	private OptionsPanel options;
	
	UI(int width, int height) {
		super(new GridBagLayout());
		game = new Game();
		game.setMinimumSize(new Dimension((int)(width * 0.6),(int) (height * 0.6)));
		options = new OptionsPanel(game);
		options.setSize(new Dimension((int)(width * 0.3),(int) (height * 0.6)));
		options.setMaximumSize(new Dimension((int)(width * 0.3),(int) (height * 0.6)));
		size = game.getsSize();
		this.add(options);
		this.add(game);
				
		UI temp = this;
		this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizePreview(game, temp);
            }
        });

	}
	
	private static void resizePreview(JPanel innerPanel, JPanel container) {
        int w = container.getWidth();
        int h = container.getHeight();
        int size =  Math.min(w, h);
        innerPanel.setPreferredSize(new Dimension(size, size));
        container.revalidate();
    }
	
	public OptionsPanel getOptions() {
		return options;
	}
	
	public Game getGame() {
		return game;
	}

}
