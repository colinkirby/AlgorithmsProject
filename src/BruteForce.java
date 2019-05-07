import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class BruteForce {

    ArrayList<Node> eulerianCircuit = new ArrayList<>();

    public BruteForce(Graph graph) {

    }

    public ArrayList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
