package com.ambrosebs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SearchTest {
  @Test
  public void readMap1() {
    Map<String, Map<String,Integer>> m1 = SearchStrategies.readGraph("map1.txt");
    Map<String, Map<String,Integer>> m2 = new HashMap();

    m2.put("A", new HashMap());
    m2.get("A").put("B", 2);
    m2.get("A").put("D", 2);

    m2.put("B", new HashMap());
    m2.get("B").put("A", 2);

    m2.put("C", new HashMap());
    m2.get("C").put("D", 2);

    m2.put("D", new HashMap());
    m2.get("D").put("A", 2);
    m2.get("D").put("C", 2);

    assertTrue(m1.equals(m2));
  }

  public static Map<String, Map<String,Integer>> g = SearchStrategies.readGraph("map1.txt");
  public static Map<String, Map<String,Integer>> g2 = SearchStrategies.readGraph("map2.txt");
  public static Map<String, Map<String,Integer>> g3 = SearchStrategies.readGraph("romania.txt");

  @Test
  public void bfsFail1() {
    Result r = SearchStrategies.findBFSPath(g, "J", "K");

    Result expected_res = null;

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res == r);
  }

  @Test
  public void dfsFail1() {
    Result r = SearchStrategies.findDFSPath(g, "J", "K");

    Result expected_res = null;

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res == r);
  }

  @Test
  public void idsFail1() {
    Result r = SearchStrategies.findIDSPath(g, "J", "K");

    Result expected_res = null;

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res == r);
  }

  // forwards single edge
  @Test
  public void bfsPathIdentity() {
    Result r = SearchStrategies.findBFSPath(g, "A", "A");

    List<String> expected = new LinkedList();
    expected.add("A");

    Result expected_res = new Result(expected, 0);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // forwards single edge
  @Test
  public void bfsPath1() {
    Result r = SearchStrategies.findBFSPath(g, "A", "D");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // backwards single edge
  @Test
  public void bfsPath2() {
    Result r = SearchStrategies.findBFSPath(g, "D", "A");

    List<String> expected = new LinkedList();
    expected.add("D"); expected.add("A");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void bfsPath3() {
    Result r = SearchStrategies.findBFSPath(g, "A", "C");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");
    expected.add("C");

    Result expected_res = new Result(expected, 4);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // forwards single edge
  @Test
  public void dfsPathIdentity() {
    Result r = SearchStrategies.findDFSPath(g, "A", "A");

    List<String> expected = new LinkedList();
    expected.add("A");

    Result expected_res = new Result(expected, 0);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // forwards single edge
  @Test
  public void dfsPath1() {
    Result r = SearchStrategies.findDFSPath(g, "A", "D");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // backwards single edge
  @Test
  public void dfsPath2() {
    Result r = SearchStrategies.findDFSPath(g, "D", "A");

    List<String> expected = new LinkedList();
    expected.add("D"); expected.add("A");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void dfsPath3() {
    Result r = SearchStrategies.findDFSPath(g, "A", "C");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");
    expected.add("C");

    Result expected_res = new Result(expected, 4);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void dfsMap2() {
    Result r = SearchStrategies.findDFSPath(g2, "A", "E");

    List<String> expected = new LinkedList();
    expected.add("A");
    expected.add("G");
    expected.add("H");
    expected.add("E");

    Result expected_res = new Result(expected, 6);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void bfsMap2() {
    Result r = SearchStrategies.findBFSPath(g2, "A", "E");

    List<String> expected = new LinkedList();
    expected.add("A");
    expected.add("F");
    expected.add("E");

    Result expected_res = new Result(expected, 4);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // forwards single edge
  @Test
  public void idsPathIdentity() {
    Result r = SearchStrategies.findIDSPath(g, "A", "A");

    List<String> expected = new LinkedList();
    expected.add("A");

    Result expected_res = new Result(expected, 0);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // forwards single edge
  @Test
  public void idsPath1() {
    Result r = SearchStrategies.findIDSPath(g, "A", "D");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // backwards single edge
  @Test
  public void idsPath2() {
    Result r = SearchStrategies.findIDSPath(g, "D", "A");

    List<String> expected = new LinkedList();
    expected.add("D"); expected.add("A");

    Result expected_res = new Result(expected, 2);

    System.out.println(r);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void idsPath3() {
    Result r = SearchStrategies.findIDSPath(g, "A", "C");

    List<String> expected = new LinkedList();
    expected.add("A"); expected.add("D");
    expected.add("C");

    Result expected_res = new Result(expected, 4);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  // 2 edges
  @Test
  public void idsMap2() {
    Result r = SearchStrategies.findIDSPath(g2, "A", "E");

    List<String> expected = new LinkedList();
    expected.add("A");
    expected.add("F");
    expected.add("E");

    Result expected_res = new Result(expected, 4);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  @Test
  public void romaniaDFS() {
    Result r = SearchStrategies.findDFSPath(g3, "Arad", "Bucharest");

    List<String> expected = new LinkedList();
    expected.add("Arad");
    expected.add("Zerind");
    expected.add("Oradea");
    expected.add("Sibiu");
    expected.add("Rimnicu Vilcea");
    expected.add("Pitesti");
    expected.add("Bucharest");

    Result expected_res = new Result(expected, 575);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  @Test
  public void romaniaBFSandIDS() {
    Result r1 = SearchStrategies.findBFSPath(g3, "Arad", "Bucharest");
    Result r2 = SearchStrategies.findIDSPath(g3, "Arad", "Bucharest");

    List<String> expected = new LinkedList();
    expected.add("Arad");
    expected.add("Sibiu");
    expected.add("Fagaras");
    expected.add("Bucharest");

    Result expected_res = new Result(expected, 450);

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r1));
    assertTrue(expected_res.equals(r2));
  }

  @Test
  public void romaniaDFSSibiu() {
    Result r = SearchStrategies.findDFSPath(g3, "Sibiu", "Eforie");

    List<String> expected = new LinkedList();
    expected.add("Sibiu");
    expected.add("Rimnicu Vilcea");
    expected.add("Pitesti");
    expected.add("Bucharest");
    expected.add("Urziceni");
    expected.add("Hirsova");
    expected.add("Eforie");

    Result expected_res = new Result(expected, 547);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  @Test
  public void romaniaBFSandIDSSibiu() {
    Result r1 = SearchStrategies.findBFSPath(g3, "Sibiu", "Eforie");
    Result r2 = SearchStrategies.findIDSPath(g3, "Sibiu", "Eforie");

    List<String> expected = new LinkedList();
    expected.add("Sibiu");
    expected.add("Fagaras");
    expected.add("Bucharest");
    expected.add("Urziceni");
    expected.add("Hirsova");
    expected.add("Eforie");

    Result expected_res = new Result(expected, 579);

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r1));
    assertTrue(expected_res.equals(r2));
  }

  @Test
  public void romaniaDFSDrobeta() {
    Result r = SearchStrategies.findDFSPath(g3, "Drobeta", "Fagaras");

    List<String> expected = new LinkedList();
    expected.add("Drobeta");
    expected.add("Mehadia");
    expected.add("Lugoj");
    expected.add("Timisoara");
    expected.add("Arad");
    expected.add("Zerind");
    expected.add("Oradea");
    expected.add("Sibiu");
    expected.add("Fagaras");

    Result expected_res = new Result(expected, 770);

    System.out.println(r);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r));
  }

  @Test
  public void romaniaBFSandIDSDrobeta() {
    Result r1 = SearchStrategies.findBFSPath(g3, "Drobeta", "Fagaras");
    Result r2 = SearchStrategies.findIDSPath(g3, "Drobeta", "Fagaras");

    List<String> expected = new LinkedList();
    expected.add("Drobeta");
    expected.add("Craiova");
    expected.add("Pitesti");
    expected.add("Bucharest");
    expected.add("Fagaras");

    Result expected_res = new Result(expected, 570);

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(expected_res);

    assertTrue(expected_res.equals(r1));
    assertTrue(expected_res.equals(r2));
  }
}
