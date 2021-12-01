package potato.project;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class CustomJSlider extends JComponent{
	private JSlider slider;
	private JLabel label;
	
	CustomJSlider(JSlider slider, JLabel label) {
		super();
		this.slider = slider;
		this.label = label;
		this.setLayout(new GridLayout(2, 1));
		this.add(label);
		this.add(slider);
	}
	
	public JSlider getSlider() {
		return slider;
	}
}
