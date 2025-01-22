package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input Graph This input represents a graph structure with cycles:
 * <p>
 * 0---1 / \ 5---2 \ / 4---3
 */
public class Graph {

  public static Map<Integer, List<Integer>> adjacencyList;

  // Constructor to initialize the adjacency list
  public Graph() {
    adjacencyList = new HashMap<>();
  }

  // Add an edge to the graph
  public void addEdge(int source, int destination) {
    adjacencyList.putIfAbsent(source, new ArrayList<>());
    adjacencyList.putIfAbsent(destination, new ArrayList<>());
    adjacencyList.get(source).add(destination);
    adjacencyList.get(destination).add(source); // For undirected graph
  }

  public static void main(String[] args) {
    Graph graph = new Graph();

    // Add edges to create a graph structure (not a tree)
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 0); // Adding a cycle
    graph.addEdge(2, 5); // Adding another cycle
  }
}
