package potato.project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Cell extends JComponent{
	private boolean isAlive;
	private int x, y;
	
	Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getXCoor() {
		return x;
	}
	
	public int getYCoor() {
		return y;
	}
	
	public boolean AliveStatus() {
		return isAlive;
	}
	
	public void setAlive(boolean status) {
		isAlive = status;
	}
	
	public void rePaint(Graphics g) {
		this.paintComponent(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isAlive)
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);
		
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
}
