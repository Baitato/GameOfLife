package potato.project;

import java.util.ArrayList;

public class Pattern {
	Pattern(Game game){}

	static int[][] Point(int x, int y) {
		return new int[][] {{x, y}};
	}
	
	static int[][] GliderSW(int x, int y) {
		return new int[][] {{x - 1, y}, {x, y - 1}, {x + 1, y - 1}, {x + 1, y}, {x + 1, y + 1}};
	}
	
	static int[][] GliderNW(int x, int y) {
		return new int[][] {{x + 1, y}, {x, y - 1}, {x - 1, y - 1}, {x - 1, y}, {x - 1, y + 1}};
	}
	
	static int[][] GliderNE(int x, int y) {
		return new int[][] {{x + 1, y}, {x, y + 1}, {x - 1, y + 1}, {x - 1, y}, {x - 1, y - 1}};
	}
	
	static int[][] GliderSE(int x, int y) {
		return new int[][] {{x - 1, y}, {x, y + 1}, {x + 1, y + 1}, {x + 1, y}, {x + 1, y - 1}};
	}
	
	static int[][] PentaDecathlon(int x, int y) {
		return new int[][] {{x, y}, {x, y + 1}, {x - 1, y + 2}, {x + 1, y + 2}, {x, y + 3}, {x, y + 4}, {x, y - 1}, {x, y - 2}, {x - 1, y - 3}, {x + 1, y - 3}, {x, y - 4}, {x, y - 5}};
	}
	
	static int[][] PentaDecathlonStraight(int x, int y) {
		return new int[][] {{x, y}, {x + 1, y}, {x + 2, y - 1}, {x + 2, y + 1}, {x + 3, y}, {x + 4, y}, {x - 1, y}, {x - 2, y}, {x - 3, y - 1}, {x - 3, y + 1}, {x - 4, y}, {x - 5, y}};
	}
}
