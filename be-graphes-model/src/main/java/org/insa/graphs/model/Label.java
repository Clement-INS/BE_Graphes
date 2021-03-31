package org.insa.graphs.model;

import java.util.ArrayList;

public class Label {
	/**
	 * Node of this label
	 */
	private int current_node;
	
	/**
	 * True when the node is known by the algorithm
	 */
	private boolean marked;
	
	/**
	 * cost of the shortest path to this node
	 */
	private int cost;
	
	/**
	 * Last arc to this node
	 */
	private Arc father;
	
	public static ArrayList<Label> Labels;
	
	public Label(int n, boolean father) {
		this.marked = false;
		if (father) {
			this.cost = 0;
		}
		else {
			this.cost = Integer.MAX_VALUE;
		}
		this.father = null;
		this.current_node = n;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public Arc getFather() {
		return father;
	}

	public void setFather(Arc father) {
		this.father = father;
	}

	public int getCost() {
		return this.cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	
	
	
}