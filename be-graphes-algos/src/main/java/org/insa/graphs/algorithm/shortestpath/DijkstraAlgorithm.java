package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Label;
import org.insa.graphs.model.Graph;
import org.insa.graphs.algorithm.utils.BinaryHeap;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        Graph graph = data.getGraph();
        BinaryHeap<Integer> BH = new BinaryHeap<Integer>();
        // initialization
        for (int i = 0; i < graph.size(); i++) {
        	Label l;
        	if (graph.getNodes().get(i).equals(data.getOrigin())) {
        		l = new Label(i, true);
        		BH.insert(i);
        	}
        	else {
        		l = new Label(i, false);
        	}
        	Label.Labels.add(l);
        }
        return solution;
    }

}
