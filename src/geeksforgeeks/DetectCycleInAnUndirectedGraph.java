package geeksforgeeks;

import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * algorithm: DFS, Union Find
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class DetectCycleInAnUndirectedGraph {

    public static void main(String[] args) {
        DetectCycleInAnUndirectedGraph solution = new DetectCycleInAnUndirectedGraph();
        solution.test1();
        solution.test2();
    }

    private void test2() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(new ArrayList<>());
        }

        list.set(0, new ArrayList<>(Arrays.asList(1, 0)));
        list.set(1, new ArrayList<>(Arrays.asList(0)));

        System.out.println(SolutionDfs.isCyclic(list, 2));
    }

    private void test1() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }

        list.set(0, new ArrayList<>(Arrays.asList(1)));
        list.set(1, new ArrayList<>(Arrays.asList(2)));
        list.set(2, new ArrayList<>(Arrays.asList(3)));

        System.out.println(SolutionDfs.isCyclic(list, 4));
    }

    private static class SolutionDfs {
        static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int n)  {
            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            return dfs(list, parent, 0, new HashSet<>());
        }

        static boolean dfs(ArrayList<ArrayList<Integer>> list, int[] parent, int s, Set<Integer> visited) {
            if (visited.contains(s)) {
                return true;
            }

            visited.add(s);

            for (int adj : list.get(s)) {
                if (parent[s] == adj) {
                    continue;
                }

                parent[adj] = s;
                if (dfs(list, parent, adj, visited)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static class SolutionDisjointSet {
        static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int n)  {
            int[] ds = new int[n];

            for (int i = 0; i < n; i++) {
                ds[i] = i;
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                set.add(i);

                for (int adj : list.get(i)) {
                    if (i == adj) {
                        return true;
                    }

                    if (set.contains(adj)) {
                        continue;
                    }

                    if (find(i, adj, ds)) {
                        return true;
                    }

                    union(i, adj, ds);
                }
            }

            return false;
        }

        private static boolean find(int x, int y, int[] ds) {
            return getRoot(x, ds) == getRoot(y, ds);
        }

        private static void union(int x, int y, int[] ds) {
            int rootX = getRoot(x, ds);
            int rootY = getRoot(y, ds);

            ds[rootX] = ds[rootY];
        }

        private static int getRoot(int x, int[] ds) {
        while (x != ds[x]) {
            ds[x] = ds[ds[x]];
            x = ds[x];
        }

        return x;
    }
    }

}
