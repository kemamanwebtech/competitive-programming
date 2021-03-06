import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 3/28/2017.
 */

public class Codeforces_Educational_round_18_NewBusRoute {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(input.nextInt());
        }
        Collections.sort(array);
        if (array.size() == 2) {
            out.println(Math.abs(array.get(0) - array.get(1)) + " " + 1);
        } else {
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < array.size() - 1; i++) {
                int after = Math.abs(array.get(i) - array.get(i + 1));
                if (after < min) {
                    min = after;
                    count = 1;
                } else if (after == min) {
                    count++;
                }
            }
            out.println(min + " " + count);
        }
        out.close();
    }

    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

