import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, totalCnt;
    static int[] data;
    static int[] keep;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        data = new int[n];
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void run() {
        for (int i = 1; i <= n; i++) {
            keep = new int[i];
            v = new boolean[n];

            recur(i, 0, 0);
        }
        System.out.println(totalCnt);
    }

    public static void recur(int now, int depth, int idx) {
        if (depth == now) {
//            System.out.println(Arrays.toString(keep));
            int sum = 0;
            for (int output : keep) {
                sum += output;
            }
            if (sum == s) {
                totalCnt++;
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            if (v[i]) continue;

            v[i] = true;
            keep[depth] = data[i];
            recur(now, depth + 1, i);
            v[i] = false;
        }
    }

}
