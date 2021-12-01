package potato.project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {
	private CustomJSlider size, delay;
	private JButton start, pause, reset;
	private JLabel generation, population;
	private JComboBox patterns;
//	private JSlider size, delay;
	private Timer timer;
	private int currentgen = 0, timerdelay = 300;
	OptionsPanel(Game game) {
		super();
		this.setLayout(new GridLayout(8, 1, 30, 50));
		start = new JButton("Start");
		pause = new JButton("Pause");
		reset = new JButton("Reset");
		generation = new JLabel("Generation : ");
		population = new JLabel("Population : ");
		patterns = new JComboBox<String>();
		patterns.setName("Patterns");
		
		patterns.addItem("Point");
		patterns.addItem("GliderSW");
		patterns.addItem("GliderNW");
		patterns.addItem("GliderNE");
		patterns.addItem("GliderSE");
		patterns.addItem("PentaDecathlon");
		patterns.addItem("PentaDecathlonStraight");
		
		patterns.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				game.setPattern((String)e.getItem());
			}
			
		});
		

		delay = new CustomJSlider(new JSlider(JSlider.HORIZONTAL, 10, 300, 100),
				new JLabel(" Delay : "));

		
		
		delay.getSlider().setMajorTickSpacing(50);
		delay.getSlider().setMinorTickSpacing(50);
//		delay.getSlider().setPaintTicks(true);
		delay.getSlider().setSnapToTicks(true);
		
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				game.reset();
				currentgen = 0;
				game.repaint();
			}
		});
		
		
		delay.getSlider().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				if(!source.getValueIsAdjusting())
					timer.setDelay(source.getValue());
			}
		});
		
		

		
		timer = new Timer(timerdelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				generation.setText("Generation : " + currentgen++);
				population.setText("Population : " + game.getPopulation());
				game.nextGeneration();
				game.repaint();
			}
		});
		
		
		
		this.add(start);
		this.add(pause);
		this.add(reset);
		this.add(patterns);
		this.add(delay);
		this.add(generation);
		this.add(population);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Controls"));
		
	}
	
}
