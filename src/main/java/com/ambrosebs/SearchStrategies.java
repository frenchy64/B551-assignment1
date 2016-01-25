package com.ambrosebs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchStrategies {

  /**
   * Generate a graph from a file.
   *
   * Format:
   *   Edge1 Edge2 42
   *   Edge2 Edge3 24
   *
   * @param filename  the name of the file containing the graph
   * @return a new graph
   */
  public static Map<String,Map<String,Integer>> readGraph(final String filename) {
    try {
      Scanner scanner = new Scanner(new File(filename));
      Map<String,Map<String,Integer>> m = new HashMap();

      while(scanner.hasNext()) {
        String line = scanner.nextLine();
        String[] words = line.split(" ");

        assert words.length == 3;

        String s = words[0];
        String e = words[1];
        Integer c = Integer.parseInt(words[2]);

        // insert forward edge
        if (!m.containsKey(s)) {
          m.put(s, new TreeMap()); //deterministic order
        }
        m.get(s).put(e, c);

        // insert reverse edge
        if (!m.containsKey(e)) {
          m.put(e, new TreeMap()); //deterministic order
        }
        m.get(e).put(s, c);
      }

      scanner.close();

      return m;
    } catch (FileNotFoundException e) {
      Util.sneakyRethrow(e);
    }
    return null; //unreachable
  }

  /**
   * Return a path from start to end, or null if impossible.
   *
   * @param g     the graph
   * @param start  initial node
   * @param end    goal node
   * @return  a path from start to end, or null
   */
  public static Result findBFSPath(final Map<String,Map<String,Integer>> g,
                                         final String start,
                                         final String end) {
    return findDBFSPath(g, start, end, "BFS");
  }

  /**
   * Return a path from start to end, or null if impossible.
   *
   * @param g     the graph
   * @param start  initial node
   * @param end    goal node
   * @return  a path from start to end, or null
   */
  public static Result findDFSPath(final Map<String,Map<String,Integer>> g,
                                   final String start,
                                   final String end) {
    return findDBFSPath(g, start, end, "DFS");
  }

  /**
   * Implements Breadth-First-Search on page 82, with option to
   * switch to DFS via a Stack.
   *
   * @param g      graph
   * @param start  starting node
   * @param end    ending node
   * @param strategy  if "BFS", perform BFS, else if "DFS", perform DFS
   * @return the result of the search
   */
  public static Result findDBFSPath(final Map<String,Map<String,Integer>> g,
                                    final String start,
                                    final String end,
                                    final String strategy) {
    assert g.containsKey(start);
    assert g.containsKey(end);
    assert strategy.equals("DFS") || strategy.equals("BFS");

    // updated in place
    Set<String> explored = new HashSet<String>();

    // updated functionally
    Node node = new Node(start, 0, new LinkedList<String>());
    node.path.add(node.state);

    if(node.state.equals(end)) {
      return new Result(node.path, node.path_cost);
    }

    // updated in place
    Deque<Node> frontier = new ArrayDeque<Node>();
    if (strategy.equals("BFS")) {
      // Queue
      frontier.addLast(node);
    } else {
      // Stack
      frontier.addFirst(node);
    }

    while(true) {
      if (frontier.isEmpty()) {
        break;
      }

      node = frontier.removeFirst();
      explored.add(node.state);

      for (Map.Entry<String, Integer> entry: g.get(node.state).entrySet()) {
        List<String> new_path = (LinkedList<String>)((LinkedList<String>)(node.path)).clone();
        // functionally update path
        new_path.add(entry.getKey());

        Node child = new Node(
                entry.getKey(),
                node.path_cost + entry.getValue(),
                new_path);
        if (!explored.contains(child.state) && !frontier.contains(child.state)) {
          if (child.state.equals(end)) {
            return new Result(child.path, child.path_cost);
          }
          frontier.add(child);
        }
      }
    }

    throw new RuntimeException("Search algorithm failed.");
  }

  public static void main(String[] argv) {

  }
}
