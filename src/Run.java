import java.util.ArrayList;
import java.util.LinkedList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;

/*
 * Runs either fluery algorithm or hierholzers depending on which block is commented.
 */
public class Run {

    public static void main(String[] args) {
        //Run multiple times to get runtime data multiple times
//        for(int i = 0; i < 100; i++) {
//            runCode();
//        }
        runCode();

    }

    /*
     * Runs either algorithm depending on which one is commented. Displays
     * the creation of the final eulerian circuit after it is deleted
     * by the algorithm
     */
    public static void runCode() {
        GraphGen graphGen = new GraphGen();
        Graph graph = graphGen.getGraph();

        long startTime = System.nanoTime();

        //Comment this block to run Hierholzers
//        Fleury fleury = new Fleury(graph);
//        ArrayList<Node> circuit = fleury.getEulerianCircuit();

        //Comment this block to run fleury
        Hierholzers holz = new Hierholzers(graph);
        ArrayList<Node> circuit = holz.getEulerianCircuit();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime); //time in nanoseconds
        System.out.println(duration);

        for(int i = 0; i < circuit.size(); i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            System.out.println(circuit.get(i));
            if(i + 1 == circuit.size()) {
                graph.addEdge(circuit.get(i) + "_" + circuit.get(0),circuit.get(i), circuit.get(0)).addAttribute("ui.color", 1);
            } else {
                graph.addEdge(circuit.get(i) + "_" + circuit.get(i + 1),circuit.get(i), circuit.get(i + 1));

            }
        }

    }
}
