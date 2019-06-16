package geeksforgeeks;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * algorithm: DFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class DetectCycleInaDirectedGraph {

    /*
    1 58 45
    31 17 11 30 6 12 32 13 7 27 10 7 5 38 25 23 33 18 1 6 49 16 11 34 32 42 13 18 33 18 34 7 36 45 37 34 0 3 47 7 30 49 14 27 30 32 50 55 50 43 53 33 1 7 9 26 49 23 36 24 33 12 23 3 0 52 38 0 55 19 57 19 3 5 46 25 37 30 22 21 15 18 55 17 25 56 43 8 13 21
    * */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov+1; i++) {
                list.add(i, new ArrayList<>());
            }

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }

            if(DetectCycleInaDirectedGraph.isCyclic(list, nov))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int n)  {
        boolean[] visited = new boolean[n];
        boolean[] explored = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, list, visited, explored)) {
                return true;
            }
        }

        return false;
    }

    static boolean dfs(int s, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] explored) {
        visited[s] = true;

        for (int adj : list.get(s)) {
            if (!explored[adj] && visited[adj]) {
                return true;
            }

            if (!visited[adj] && dfs(adj, list, visited, explored)) {
                return true;
            }
        }

        explored[s] = true;

        return false;
    }

}
