import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * This mess creates a Chvatal graph with 12 vertices which all have
 * 4 neighbors. It should meet the requirements to find a Eulerian circuit.
 * Check out the GraphStream documentation to see what stuff you can
 * do with the nodes
 */
public class GraphGen {

    static LinkedList<Node>[] adjacencyList;

    public GraphGen() {
        Graph graph = new SingleGraph("Chvatal");
        Generator gen = new ChvatalGenerator();
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 100; i++) {
            gen.nextEvents();
        }

        gen.end();
        graph.display();

        int n = graph.getNodeCount();
        adjacencyList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            Node node = graph.getNode(i);
            node.addAttribute("ui.style", "shape:circle;fill-color: yellow;size: 20px; text-alignment: center;");
            node.addAttribute("ui.label", i+1);
            adjacencyList[i] = new LinkedList<Node>();
            adjacencyList[i].add(node);

            Iterator iterator = node.getEachEdge().iterator();
            while (iterator.hasNext()) {
                String edge = iterator.next().toString();
                if(Integer.parseInt(edge.substring(0,2)) == i+1) {
                    adjacencyList[i].add(graph.getNode(edge.substring(3,5)));
                } else {
                    adjacencyList[i].add(graph.getNode(edge.substring(0,2)));
                }
            }
        }
    }

    public static LinkedList<Node>[] getAdjacencyList() {
        return adjacencyList;
    }
}
