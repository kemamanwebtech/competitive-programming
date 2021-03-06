import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 4/7/2016.
 */
public class Codeforces_VKCup_2016_round_1_ChatOrder {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < count; i++) {
            String current = input.nextLine();
            if(!map.containsKey(current)) {
                map.put(current, index++);
            } else {
                map.remove(current);
                map.put(current, index++);
            }
        }
        TreeSet<String> keys = new TreeSet<String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -1 * map.get(o1).compareTo(map.get(o2));
            }
        });
        keys.addAll(map.keySet());
        for(String x : keys) {
            out.println(x);
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