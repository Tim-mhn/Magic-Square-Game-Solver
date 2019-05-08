package input;

import java.util.*;

public class Position {

	private int x;
	private int y;
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public ArrayList<Position> getAllPotentialDestinations() {
		
		ArrayList<Position> potentialDestinations = new ArrayList<Position>(
				Arrays.asList(new Position(x,y-3), new Position(x-2,y-2), new Position(x+2,y-2),
						new Position(x-2,y+2), new Position(x+2,y+2), new Position(x,y+3),
						new Position(x-3,y), new Position(x+3,y)));
		
		
		return potentialDestinations;
	}

	
	public boolean equals(Position p) {
		return (x == p.getX() && y == p.getY());
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
