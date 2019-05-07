import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;

public class Fleury {

    LinkedList<Node> eulerianCircuit = new LinkedList<>();

    public Fleury(LinkedList<Node> graph) {
        Node startNode = graph.getFirst();
        Graph g = startNode.getGraph();
        Iterator nodes = startNode.getNeighborNodeIterator();
        while (nodes.hasNext()){
            if (isValidEdge(startNode, (Node) nodes.next())){
                eulerianCircuit.add(startNode);
                System.out.println(startNode.getIndex() + "-" + ((Node) nodes.next()).getIndex() );
                g.removeEdge(startNode, (Node) nodes.next());

               // Fleury(GraphGen.getAdjacencyList());???
            }
        }


    }

    public boolean isValidEdge(Node a, Node b){
        if (a.getDegree() == 1){
            return true;
        }
        else{
            Graph g = a.getGraph();
            int reachableNodes1 = countReachables(a);
            g.removeEdge(a, b);
            int reachableNodes2 = countReachables(b);
            g.addEdge("ui.label", a, b);
            return (reachableNodes1 <= reachableNodes2);
        }
    }

    public int countReachables(Node n){
        Iterator nieghbors = n.getNeighborNodeIterator();
        int count = 1;
        while (nieghbors.hasNext()){
            count = count + countReachables((Node) nieghbors.next())
        }
        return count;
    }


    public LinkedList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
