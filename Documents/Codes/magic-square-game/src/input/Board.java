package input;

import java.util.*;

public class Board {
	
	private ArrayList<Position> occupiedPositions = new ArrayList<Position>();
	private int size;
	
	public Board(int size) {
		this.size = size;
	}
	
	public Board(ArrayList<Position> occupiedPositions) {
		super();
		this.size = size;
		this.occupiedPositions = occupiedPositions;
	}

	public ArrayList<Position> getOccupiedPositions() {
		return occupiedPositions;
	}
	
	public void setOccupiedPositions(ArrayList<Position> occupiedPositions) {
		this.occupiedPositions = occupiedPositions;
	}
	
	public void addPosition(Position pos) {
		this.occupiedPositions.add(pos);
	}
	
	public Position getLastPosition() {
		return this.occupiedPositions.get(this.occupiedPositions.size()-1);
	}
	
	public void removeLastPosition() {
		this.occupiedPositions.remove(this.occupiedPositions.size()-1);
	}
	
	// Checks whether a given position exists already in the board's occupiedPositions list
	public boolean containsPosition(Position pos) {
		boolean contains = false;
		int i = 0;
		Position position = null;
		while (i<this.occupiedPositions.size() && !contains) {
			position = this.occupiedPositions.get(i);
			if(position.equals(pos)) {
				contains = true;
			}
			i++;
		}
		return contains;
	}
	
	
	
	public boolean canAddPosition(Position pos) {
		int x = pos.getX();
		int y = pos.getY();
		boolean checkX = 0<=x && x<this.size;
		boolean checkY = 0<=y && y<this.size;
		
		return (checkX && checkY && !this.containsPosition(pos));
	}
	
	public ArrayList<Position> getPossiblePositions() {
		// get possible positions according to the last position of the board
		Position currentPos = this.getLastPosition();
		// we go through all 8 potential positions and then check if they are already in the list of occupied positions
		
		ArrayList<Position> potentialDestinations = currentPos.getAllPotentialDestinations(); // List of all potential destinations
		ArrayList<Position> possibleDestinations = new ArrayList<Position>();
		
		for(Position pos : potentialDestinations) { // we only keep possible destinations
			if (this.canAddPosition(pos)) {
				possibleDestinations.add(pos);
				//System.out.print(possibleDestinations);
			}
		}
		
		return possibleDestinations;
		
		
	}
	
	public void clear() {
		this.occupiedPositions.clear();
	}
	
	public static void main(String[] args) {
		Position pos = new Position(2,3);
		Board b = new Board(5);
		b.addPosition(new Position(0,0));
		// ArrayList<Position> possiblePositions = pos.getAllPotentialDestinations();
		//ArrayList<Position> possiblePositions = b.getPossiblePositions();
		
		Position p1 = new Position(0,0);
		Position p2 = new Position(0,0);
		System.out.print(p1.equals(p2));
	
		
		
	}
	
}
