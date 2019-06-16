package geeksforgeeks;

import java.util.ArrayList;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * algorithm: DFS
 * time complexity: O(V+E)
 * space complexity: O(V+E)
 */
public class DFSofGraph {

    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        vis[src] = true;

        System.out.print(src + " ");

        for (int adj : list.get(src)) {
            if (!vis[adj]) {
                dfs(adj, list, vis);
            }
        }
    }

}
