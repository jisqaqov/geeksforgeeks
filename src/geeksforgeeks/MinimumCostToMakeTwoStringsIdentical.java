package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Jandos Iskakov
 * problem: Minimum Cost To Make Two Strings Identical
 * algorithm: DP
 * time complexity: O(|S|*|T|)
 * space complexity: O(|S|*|T|)
 */
public class MinimumCostToMakeTwoStringsIdentical {
    private FastReader in;
    private PrintWriter out;

    public MinimumCostToMakeTwoStringsIdentical() {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }

    public static void main(String args[]) throws Exception {
        MinimumCostToMakeTwoStringsIdentical solution = new MinimumCostToMakeTwoStringsIdentical();
        solution.solve();
    }

    private void solve() throws IOException {
        int k = in.nextInt();

        while (k > 0) {
            int costS = in.nextInt();
            int costT = in.nextInt();

            String s = in.next();
            String t = in.next();

            System.out.println(solve(s, t, costS, costT));

            k--;
        }

        in.close();
        out.close();
    }

    private int solve(String s, String t, int costS, int costT) {
        int n = s.length(), m = t.length();

        int[][] cost = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    cost[i][j] = 0;
                } else if (i == 0) {
                    cost[i][j] = cost[i][j - 1] + costT;
                } else if (j == 0) {
                    cost[i][j] = cost[i - 1][j] + costS;
                } else {
                    char chS = s.charAt(i - 1);
                    char chT = t.charAt(j - 1);

                    if (chS == chT) {
                        cost[i][j] = cost[i - 1][j - 1];
                    } else {
                        cost[i][j] = Math.min(cost[i - 1][j] + costS, cost[i][j - 1] + costT);
                    }
                }
            }
        }

        return cost[n][m];
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
