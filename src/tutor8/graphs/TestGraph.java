package tutor8.graphs;

import java.util.ArrayList;

public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile1("graph.txt");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g.depthFirstSearch();
        System.out.println("Depth First Search: ");
        g.printEdges(edges, System.out);
    }
}
