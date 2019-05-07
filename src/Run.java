import java.util.LinkedList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

/*
 * This class could probably be used to run both the Fleury and the brute force algorithm
 * and we can then do a time analysis. The algorithms should both return a list of Nodes
 * in the order of the Eulerian circuit. From there I can do some sort of visualization
 * of the edges
 */
public class Run {

    public static void main(String[] args) {
        GraphGen graphGen = new GraphGen();

        LinkedList<Node>[] graph = graphGen.getAdjacencyList();

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                System.out.println(graph[i].get(j));
            }
            System.out.println("===============");
        }

    }
}
