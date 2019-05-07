import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import java.util.LinkedList;

public class BruteForce {

    LinkedList<Node> eulerianCircuit = new LinkedList<>();

    public BruteForce(LinkedList<Node> graph) {

    }

    public LinkedList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
