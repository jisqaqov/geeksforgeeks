package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Jandos Iskakov
 * problem: https://practice.geeksforgeeks.org/problems/steps-by-knight/0
 * algorithm: BFS
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 */
public class StepsByKnight0 {
    private FastReader in;
    private PrintWriter out;

    public StepsByKnight0() {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }

    public static void main(String args[]) throws Exception {
        StepsByKnight0 solution = new StepsByKnight0();
        solution.solve();
    }

    private void solve() throws IOException {
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();

            int sx = in.nextInt();
            int sy = in.nextInt();


            int tx = in.nextInt();
            int ty = in.nextInt();

            out.println(solve(n, n, sx - 1, sy - 1, tx - 1, ty - 1));

            t--;
        }

        in.close();
        out.close();
    }

    private int solve(int n, int m, int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy});

        List<Integer> stepsOf2 = Arrays.asList(-2, 2);
        List<Integer> stepsOf1 = Arrays.asList(-1, 1);

        int[][] dis = new int[n][m];
        dis[sx][sy] = 0;

        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x == tx && y == ty) {
                return dis[x][y];
            }

            for (int s1 : stepsOf1) {
                for (int s2 : stepsOf2) {
                    int ax1 = x + s1, ay1 = y + s2;
                    if (ax1 >= 0 && ay1 >= 0 && ax1 < n && ay1 < m && !visited[ax1][ay1]) {
                        queue.add(new int[] {ax1, ay1});
                        dis[ax1][ay1] = dis[x][y] + 1;
                        visited[ax1][ay1] = true;
                    }

                    int ax2 = x + s2, ay2 = y + s1;
                    if (ax2 >= 0 && ay2 >= 0 && ax2 < n && ay2 < m && !visited[ax2][ay2]) {
                        dis[ax2][ay2] = dis[x][y] + 1;
                        queue.add(new int[]{ax2, ay2});
                        visited[ax2][ay2] = true;
                    }
                }
            }
        }

        return 1;
    }

    private static class FastReader {
        private BufferedReader br;
        private StringTokenizer tok = new StringTokenizer("");

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public void close() throws IOException {
            br.close();
        }
    }

}
