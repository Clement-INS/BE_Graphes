package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.LabelStar;
import org.insa.graphs.model.Label;
import org.insa.graphs.model.Node;

public class AStarAlgorithm extends DijkstraAlgorithm {

	@Override
	protected void insert(BinaryHeap<Label> BH, Node n, boolean Marked, float cost, Arc father, ShortestPathData data) {
    	Label l;
    	float estimated_cost;
    	double max_speed = Math.max(data.getMaximumSpeed(), data.getGraph().getGraphInformation().getMaximumSpeed());
    	if (data.getMode() == Mode.LENGTH) {
    		estimated_cost = (float)n.getPoint().distanceTo(data.getDestination().getPoint());
    	}
    	else {
    		estimated_cost = (float)n.getPoint().distanceTo(data.getDestination().getPoint())/(float)max_speed;
    	}
		l = new LabelStar(n, Marked, cost, father, estimated_cost);
		BH.insert(l);
		Label.Labels[n.getId()] = l;
		notifyNodeReached(l.getCurrentNode());
    }
    
    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    

    
}
