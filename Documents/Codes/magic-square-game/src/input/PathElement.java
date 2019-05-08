package input;

import java.util.*;

public class PathElement {

	private Position position;
	private ArrayList<Position> nextPositions;
	private int lastExplored;
	private int depthIndex;
	
	public PathElement(Position position, ArrayList<Position> nextPositions, int lastExplored, int depthIndex) {
		super();
		this.position = position;
		this.nextPositions = nextPositions;
		this.lastExplored = lastExplored;
		this.depthIndex = depthIndex;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public ArrayList<Position> getNextPositions() {
		return nextPositions;
	}

	public void setNextPositions(ArrayList<Position> nextPositions) {
		this.nextPositions = nextPositions;
	}

	public int getLastExplored() {
		return lastExplored;
	}
	
	public boolean isAllExplored() {
		return this.lastExplored>=(this.nextPositions.size()-1);
	}

	public void setLastExplored(int lastExplored) {
		this.lastExplored = lastExplored;
	}

	public Position getUnexploredPosition() {
		this.incrementLastExplored();
		return this.nextPositions.get(lastExplored);
	}
	public void incrementLastExplored() {
		this.setLastExplored(this.getLastExplored()+1);
	}
	
	public int getDepthIndex() {
		return depthIndex;
	}

	
	public void setDepthIndex(int depthIndex) {
		this.depthIndex = depthIndex;
	}

	@Override
	public String toString() {
		return "PathElement [position=" + position + ", nextPositions=" + nextPositions + ", lastExplored="
				+ lastExplored + ", depthIndex=" + depthIndex + "]";
	}
	
	
	
	
}
