import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*
 * Implements Hierholzers algorithm from a given graph
 */
public class Hierholzers {

    ArrayList<Node> eulerianCircuit = new ArrayList<>();
    Stack<Node> stack = new Stack();
    static Graph graph;

    public Hierholzers(Graph graph) {
        this.graph = graph;
        Node startNode = graph.getNode(0);
        stack.push(startNode);
        makeEulerTour();
    }

    public void makeEulerTour() {
        while(!stack.empty()) {
            Node node = stack.peek();
            int k = node.getDegree();

            if(k > 0) {
                Edge edge = node.getEdge(0);
                //System.out.println(edge);
                Node pushNode = edge.getNode1();
                if(pushNode != node) {
                    stack.push(edge.getNode1());
                } else {
                    stack.push(edge.getNode0());
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                graph.removeEdge(edge);
            } else {
                Node circNode = stack.pop();
                eulerianCircuit.add(circNode);
            }
        }
    }


    /*
     * Retrieve finished eulerian circuit
     */
    public ArrayList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
