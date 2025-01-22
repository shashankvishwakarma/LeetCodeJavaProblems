package dsa.graphs;

import static dsa.graphs.Graph.adjacencyList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {

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

    // Perform DFS and BFS
    dfs(0); // DFS Traversal: 0 1 3 4 5 2
    bfs(0); // BFS Traversal: 0 1 2 5 3 4
  }

  // Perform DFS traversal
  public static void dfs(int start) {
    Set<Integer> visited = new HashSet<>();
    System.out.print("DFS Traversal: ");
    dfsHelper(start, visited);
    System.out.println();
  }

  private static void dfsHelper(int node, Set<Integer> visited) {
    visited.add(node);
    System.out.print(node + " ");

    for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
      if (!visited.contains(neighbor)) {
        dfsHelper(neighbor, visited);
      }
    }
  }

  // Perform BFS traversal
  public static void bfs(int start) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);

    System.out.print("BFS Traversal: ");
    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");

      for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
        if (!visited.contains(neighbor)) {
          queue.offer(neighbor);
          visited.add(neighbor);
        }
      }
    }
    System.out.println();
  }


}
