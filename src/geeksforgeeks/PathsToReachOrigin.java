package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Jandos Iskakov
 * problem: Paths to reach origin
 * algorithm: DP
 * time complexity: O(N*M)
 * space complexity: O(N*M)
 */
public class PathsToReachOrigin {
    private FastReader in;
    private PrintWriter out;

    public PathsToReachOrigin() {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }

    public static void main(String args[]) throws Exception {
        PathsToReachOrigin solution = new PathsToReachOrigin();
        solution.solve();
    }

    private void solve() throws IOException {
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] memo = new int[n + 1][m + 1];

            out.println(solve(0, 0, n, m, memo));

            t--;
        }

        in.close();
        out.close();
    }

    private int solve(int i, int j, int n, int m, int[][] memo) {
        if (i == n && j == m) {
            return 0;
        } else if (i == n || j == m) {
            return 1;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        memo[i][j] = solve(i + 1, j, n, m, memo) + solve(i, j + 1, n, m, memo);

        return memo[i][j];
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
