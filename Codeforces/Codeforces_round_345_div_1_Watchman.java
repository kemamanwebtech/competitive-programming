import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 4/9/2016.
 */
public class Codeforces_round_345_div_1_Watchman {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int pair = input.nextInt();
        HashMap<Long, Long> xPlane = new HashMap<>();
        HashMap<Long, Long> yPlane = new HashMap<>();
        HashMap<Point, Long> points = new HashMap<>();
        for (int i = 0; i < pair; i++) {
            long x = input.nextLong();
            long y = input.nextLong();
            if(!xPlane.containsKey(x)) {
                xPlane.put(x, (long)1);
            } else if(xPlane.containsKey(x)){
                xPlane.put(x, xPlane.get(x) + 1);
            }
            if(!yPlane.containsKey(y)) {
                yPlane.put(y, (long)1);
            } else if(yPlane.containsKey(y)){
                yPlane.put(y, yPlane.get(y) + 1);
            }
            Point current = new Point(x, y);
            if(!points.containsKey(current)) {
                points.put(current, (long)1);
            } else if(points.containsKey(current)){
                points.put(current, points.get(current) + (long)1);
            }
        }
        long summation = 0;
        for(Long x : xPlane.keySet()) {
            long count = xPlane.get(x);
            summation += (count * (count - 1)) / 2;
        }
        for(Long y : yPlane.keySet()) {
            long count = yPlane.get(y);
            summation += (count * (count - 1)) / 2;
        }
        for(Point current : points.keySet()) {
            long count = points.get(current);
            summation -= (count * (count - 1)) / 2;
        }
        System.out.println(summation);
    }

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (int)(x * 10 + y);
        }

        @Override
        public boolean equals(Object obj) {
            Point compare = (Point)obj;
            return this.x == compare.x && this.y == compare.y;
        }
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

