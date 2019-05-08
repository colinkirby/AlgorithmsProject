import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Implements Fleury's algorithm from a given graph
 */
public class Fleury {

    ArrayList<Node> eulerianCircuit = new ArrayList<>();
    static Graph graph;

    public Fleury(Graph graph) {
        this.graph = graph;
        Node startNode = graph.getNode(0);
        makeEulerTour(startNode);
    }

    public void makeEulerTour(Node n) {
        int k = graph.getNodeCount();
        for(int i = 1; i <= k; i++) {
            Node neighbor = (Node) graph.getNode(i - 1);

            if(n.hasEdgeBetween(neighbor)) {
                Edge edge = n.getEdgeBetween(neighbor);

                if(isValidEdge(n, neighbor)) {
                    eulerianCircuit.add(n);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                    graph.removeEdge(n, neighbor);
                    makeEulerTour(neighbor);
                }
            }

        }
    }

    public boolean isValidEdge(Node a, Node b){
        if (a.getDegree() == 1){
            return true;
        }
        else{
            int reachableNodes1 = countReachables(a, new ArrayList<Node>());
            graph.removeEdge(a, b);
            int reachableNodes2 = countReachables(b, new ArrayList<Node>());
            graph.addEdge(a + "_" + b, a, b);
            return (reachableNodes1 <= reachableNodes2);
        }
    }

    public int countReachables(Node n, ArrayList<Node> vistited){
        Iterator neighbors = n.getNeighborNodeIterator();
        int count = 1;
        vistited.add(n);
        while (neighbors.hasNext()){
            Node neighbor = (Node) neighbors.next();
            if(!vistited.contains(neighbor)) {
                count = count + countReachables(neighbor, vistited);
            }
        }
        return count;
    }

    /*
     * Retrieve finished eulerian circuit
     */
    public ArrayList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
