package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberOfPaths0 {
    private FastReader in;
    private PrintWriter out;


    public NumberOfPaths0() {
        in = new FastReader();
        out = new PrintWriter(System.out);
    }

    public static void main(String args[]) throws Exception {
        NumberOfPaths0 solution = new NumberOfPaths0();
        solution.solve();
    }

    private void solve() throws IOException {
        int t = in.nextInt();

        while (t > 0) {
            int m = in.nextInt();
            int n = in.nextInt();

            System.out.println(solve(new int[m][n], m - 1, n - 1));

            t--;
        }

        in.close();
        out.close();
    }

    private int solve(int[][] memo, int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        return solve(memo, m - 1, n) + solve(memo, m, n - 1);
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
