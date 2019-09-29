package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * algorithm: Union Find
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class DetectCycleInAnUndirectedGraph {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      int nov = sc.nextInt();
      int edg = sc.nextInt();

      for (int i = 0; i < nov + 1; i++) {
        list.add(i, new ArrayList<>());
      }

      for (int i = 1; i <= edg; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();

        list.get(u).add(v);
        list.get(v).add(u);
      }

      if (isCyclicUsingBfs(list, nov)) {
        System.out.println("1");
      } else {
        System.out.println("0");
      }
    }
  }

  static boolean isCyclicUsingUnionFind(ArrayList<ArrayList<Integer>> list, int n) {
    if (n == 0 || list.size() == 0) {
      return false;
    }

    int[] ds = new int[n];
    for (int i = 0; i < n; i++) {
      ds[i] = i;
    }

    Map<Integer, Set<Integer>> adjList = new HashMap<>();

    for (int u = 0; u < n; u++) {
      adjList.putIfAbsent(u, new HashSet<>());

      for (int v : list.get(u)) {
        if (adjList.get(u).contains(v)) {
          return true;
        }

        adjList.get(u).add(v);
      }
    }

    Map<Integer, Set<Integer>> visited = new HashMap<>();

    for (int u = 0; u < n; u++) {
      for (int v : list.get(u)) {
        if (visited.containsKey(u) && visited.get(u).contains(v)) {
          continue;
        }

        if (u == v || parent(ds, u) == parent(ds, v)) {
          return true;
        }

        visited.putIfAbsent(u, new HashSet<>());
        visited.putIfAbsent(v, new HashSet<>());

        visited.get(u).add(v);
        visited.get(v).add(u);

        union(ds, u, v);
      }
    }

    return false;
  }

  static boolean isCyclicUsingBfs(ArrayList<ArrayList<Integer>> list, int n) {
    if (n == 0 || list.size() == 0) {
      return false;
    }

    Set<Integer> visited = new HashSet<>();

    for (int u = 0; u < n; u++) {
      if (visited.contains(u)) {
        continue;
      }

      visited.add(u);

      Queue<Integer> queue = new LinkedList<>();
      queue.add(u);

      Set<Integer> marked = new HashSet<>();

      while (!queue.isEmpty()) {
        int curr = queue.poll();

        visited.add(curr);

        for (int v : list.get(curr)) {
          if (curr == v) {
            return true;
          }

          if (visited.contains(v)) {
            continue;
          }

          if (marked.contains(v)) {
            return true;
          }

          marked.add(v);
          queue.add(v);
        }
      }

      visited.addAll(marked);
    }

    return false;
  }

  private static int parent(int[] ds, int i) {
    while (ds[i] != i) {
      ds[i] = ds[ds[i]];
      i = ds[i];
    }

    return i;
  }

  private static void union(int[] ds, int i, int j) {
    int rootX = parent(ds, i);
    int rootY = parent(ds, j);

    ds[rootX] = rootY;
  }

}
