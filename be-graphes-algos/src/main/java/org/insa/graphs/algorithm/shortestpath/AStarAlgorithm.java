package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.LabelStar;
import org.insa.graphs.model.Label;
import org.insa.graphs.model.Node;

public class AStarAlgorithm extends DijkstraAlgorithm {

	@Override
	protected void insert(BinaryHeap<Label> BH, Node n, boolean Marked, float cost, Arc father, float estimated_cost) {
    	Label l;
		l = new LabelStar(n, Marked, cost, father, estimated_cost);
		BH.insert(l);
		Label.Labels[n.getId()] = l;
		notifyNodeReached(l.getCurrentNode());
    }
    
    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    

    
}
