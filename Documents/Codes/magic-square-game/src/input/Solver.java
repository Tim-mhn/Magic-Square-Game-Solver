package input;

import java.util.*;

public class Solver {

	private int size;
	private Board board;
	private ArrayList<PathElement> path = new ArrayList<PathElement>();
	
	public Solver(int size) {
		this.size = size;
		this.board = new Board(size);
	}
	
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	public ArrayList<PathElement> getPath() {
		return path;
	}


	public void setPath(ArrayList<PathElement> path) {
		this.path = path;
	}


	public void initializePath(Position pos) {
		this.board.clear();
		this.path.clear();
		this.board.addPosition(pos);
		ArrayList<Position> possiblePositions = this.board.getPossiblePositions();
		PathElement firstElement = new PathElement(pos, possiblePositions, -1, 0);
		path.add(firstElement);
	}
	
	public ArrayList<Position> getPossiblePositions(){
		return this.board.getPossiblePositions();
	}
	
	public void addPathElement(PathElement el) {
		this.path.add(el);
		this.board.addPosition(el.getPosition());
	}
	
	public void removeLastPosition() {
		this.path.remove(this.path.size()-1);
		this.board.removeLastPosition();
	}
	
	public ArrayList<Position> getAllPositions(){
		ArrayList<Position> allPositions = new ArrayList<Position>();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; i++) {
				allPositions.add(new Position(i,j));
			}
		}
		
		return allPositions;
	}
	
	public ArrayList<PathElement> explore(){
		int depth = 0;
		//int startIndex = 0;
		//ArrayList<Position> startPositions = getAllPositions();
		//System.out.print("Startpositions: " + startPositions);
		
		
		initializePath(new Position(0,0));
			
			
			System.out.print("\r\n\r\npath size" + this.path.size());
			while(this.path.size()<49 && depth>=0) {
				
				PathElement element = this.path.get(depth);
				
				if(!element.isAllExplored()) {
					
					Position nextPos = element.getUnexploredPosition();
					//System.out.print(nextPos);
					//this.board.addPosition(nextPos);
					PathElement nextElement = new PathElement(nextPos, getPossiblePositions(), -1, depth);
					addPathElement(nextElement);
					depth += 1;
				} else if (depth >= 0) {
					removeLastPosition();
					depth -= 1;
				} else {
					System.out.print("impossible");
					return null;
				}
			}
		
	
		
		ArrayList<Position> finalPath = new ArrayList<Position>();
		for(PathElement el : path) {
			finalPath.add(el.getPosition());
		}
		System.out.print("\r\n\r\n FinalPath:" + finalPath);
		return this.path;
	}
	
	public static void main (String[] args) {
		
		Solver s = new Solver(5);
		//s.initializePath(new Position(0,0));
		//System.out.print("First element: \r\n");
		//System.out.print(s.getPath().get(0));
		s.explore();
	}
}
