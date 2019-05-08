import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.generator.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Creates a Chvatal graph which where all 12 vertices have a degree of 4
 * Other graphs can be created easily, but they were removed for readablity
 * reasons
 */
public class GraphGen {

    static Graph graph;

    public GraphGen() {
        graph = new SingleGraph("Chvatal");
        graph.addAttribute("ui.stylesheet", "node {shape: box;fill-color: blue, green, red;text-mode:normal;text-background-mode: plain; fill-mode: dyn-plain;}");

        Generator gen = new ChvatalGenerator();
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 100; i++) {
            gen.nextEvents();
        }

        gen.end();
        graph.display();

        int n = graph.getNodeCount();

        for (int i = 0; i < n; i++) {
            Node node = graph.getNode(i);

            if(i != 0) {
                node.addAttribute("ui.color",0);
                node.addAttribute("layout.frozen");
                node.addAttribute("xy", 2, 0);

            } else {
                node.addAttribute("ui.color",220);
                node.addAttribute("layout.frozen");
                node.addAttribute("xy", 2, 0);
            }
            node.addAttribute("ui.label", i + 1);
            node.addAttribute("xy", Math.random() * 200 + 10, Math.random() * 200 + 10);

        }
    }

    public Graph getGraph() {
        return graph;
    }
}
