import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

import java.util.LinkedList;

public class Fleury {

    LinkedList<Node> eulerianCircuit = new LinkedList<>();

    public Fleury(LinkedList<Node> graph) {

    }


    public LinkedList<Node> getEulerianCircuit() {
        return eulerianCircuit;
    }
}
