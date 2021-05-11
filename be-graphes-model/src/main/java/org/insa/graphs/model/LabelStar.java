package org.insa.graphs.model;

public class LabelStar extends Label {
	
	/**
	 * cost of the flying distance
	 */
	private float estimated_cost;
	
	public LabelStar(Node n, boolean Marked, float cost, Arc father, float estimated_cost) {
		super(n, Marked, cost, father);
		this.estimated_cost = estimated_cost;
	}
	
	public float getTotalCost() {
		return this.cost+this.estimated_cost;
	}
	
}