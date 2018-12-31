package za.co.shortestpath.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Node {
    
    private Integer x_coordinate;
    private Integer y_coordinate;
    private String symbol;
    private List<Node> shortestPath;
    private Integer distance;
    private List<Node> adjacentNodes;
    
    
   /*  
    public Node() {
		super();
		this.x_coordinate = -1;
		this.y_coordinate = -1;
	}
*/


	public Node(Integer x_coordinate, Integer y_coordinate,String symbol) {
		super();
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
		this.symbol =symbol;
		this.shortestPath = new LinkedList<>();
		this.distance = Integer.MAX_VALUE;
		this.adjacentNodes = new ArrayList<>();
	}
 
    
 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : prime);
		result = prime * result + x_coordinate;
		result = prime * result + y_coordinate;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (adjacentNodes == null) {
			if (other.adjacentNodes != null)
				return false;
		} else if (!adjacentNodes.equals(other.adjacentNodes))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (shortestPath == null) {
			if (other.shortestPath != null)
				return false;
		} else if (!shortestPath.equals(other.shortestPath))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (x_coordinate != other.x_coordinate)
			return false;
		if (y_coordinate != other.y_coordinate)
			return false;
		return true;
	}



	public void addDestination(Node destination) {
        adjacentNodes.add(destination);
    }


	public int getX_coordinate() {
		return x_coordinate;
	}


	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}


	public int getY_coordinate() {
		return y_coordinate;
	}


	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}


	public List<Node> getShortestPath() {
		return shortestPath;
	}


	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}


	public Integer getDistance() {
		return distance;
	}


	public void setDistance(Integer distance) {
		this.distance = distance;
	}


	public List<Node> getAdjacentNodes() {
		return adjacentNodes;
	}


	public void setAdjacentNodes(List<Node> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	@Override
	public String toString() {
		return "Node [x_coordinate=" + x_coordinate + ", y_coordinate=" + y_coordinate + ", symbol=" + symbol + "]";
	} 
	

}