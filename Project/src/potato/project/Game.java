package potato.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Game extends JPanel implements MouseListener{
	private Cell cells[][];
	private int size = 100;
	private int population = 0;
	private int borderThickness = 1;
	private String current_pattern = "Point";
	Game() {
		super();
		this.addMouseListener(this);
		this.setLayout(new GridLayout(size, size));
		cells = new Cell[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells[i][j] = new Cell(i, j); 
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;

                if (i == 0)
                    top = borderThickness;
                else if (i == size - 1)
                    bottom = borderThickness;
                
                if (j == 0)
                    left = borderThickness;
                else if (j == size - 1)
                    right = borderThickness;
                
                Border border = BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
                cells[i][j].setBorder(border);
				this.add(cells[i][j]);
			}
		}
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells[i][j].paintComponent(g);
			}
		}
	}
	
	public void reset() {
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				cells[i][j].setAlive(false);
	}
	
	public int getPopulation() {
		return population;
	}
	
	public Cell[][] getGrid() {
		return cells;
	}
	
	public int getsSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.setLayout(new GridLayout(size, size));
		this.size = size;	
	}
	
	public void setPattern(String p)
	{
		current_pattern = p;
	}
	
	int countNeighbours(int x, int y) {
		int count = 0;
		int[] xDir = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] yDir = {-1, 0, 1, 1, 1, 0, -1, -1};
		
		for(int i = 0; i < 8; i++) {
			if(checkValid(x + xDir[i], y + yDir[i]) && cells[x + xDir[i]][y + yDir[i]].AliveStatus())
				count++;
		}
		return count;
	}
	
	boolean checkValid(int x, int y) {
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
	
	void nextGeneration() {
		boolean[][] temp = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int neighbours = countNeighbours(i, j);
				if(cells[i][j].AliveStatus()) {
					if(neighbours < 2 || neighbours > 3)
					{
						temp[i][j] = false;
						population--;
					}
					else
						temp[i][j] = true;

				}
				else {
					if(neighbours == 3)
					{
						temp[i][j] = true;
						population++;
					}
				}
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells[i][j].setAlive(temp[i][j]);
			}
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Cell c = (Cell) this.getComponentAt(e.getX(), e.getY());
		int[][] a = null;
		
		
		if(current_pattern.equals("Point")) 
			a = Pattern.Point(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("GliderSW")) 
			a = Pattern.GliderSW(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("GliderNW")) 
			a = Pattern.GliderNW(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("GliderNE")) 
			a = Pattern.GliderNE(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("GliderSE")) 
			a = Pattern.GliderSE(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("PentaDecathlon"))
			a = Pattern.PentaDecathlon(c.getXCoor(), c.getYCoor());
		else if(current_pattern.equals("PentaDecathlonStraight"))
			a = Pattern.PentaDecathlonStraight(c.getXCoor(), c.getYCoor());
			
		for(int i = 0; i < a.length; i++)
			if(checkValid(a[i][0], a[i][1]))
				cells[a[i][0]][a[i][1]].setAlive(true);
		population += a.length;

		repaint();
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
