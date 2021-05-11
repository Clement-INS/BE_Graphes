package org.insa.graphs.model;

public class Label implements Comparable<Label> {
	/**
	 * Node of this label
	 */
	private Node current_node;
	
	/**
	 * True when the node is known by the algorithm
	 */
	private boolean marked;
	
	/**
	 * cost of the shortest path to this node
	 */
	protected float cost;
	
	/**
	 * Last arc to this node
	 */
	private Arc father;
	
	public static Label[] Labels;
	
	public Label(Node n, boolean Marked, float cost, Arc father) {
		this.current_node = n;
		this.marked = Marked;
		this.cost = cost;
		this.father = father;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public Node getCurrentNode() {
		return current_node;
	}
	
	public Arc getFather() {
		return father;
	}

	public void setFather(Arc father) {
		this.father = father;
	}

	public float getCost() {
		return this.cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public float getTotalCost() {
		return this.cost;
	}
	
	@Override
	public int compareTo(Label l) {
		return Float.compare(this.getTotalCost(), l.getTotalCost());
	}
	

	
	
	
}