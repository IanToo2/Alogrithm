import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int dasom;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur >= dasom) {
                dasom++;
                cnt++;
                q.add(cur-1);
//                System.out.println(q);
            } else {
                break;
            }
//            System.out.println("dasom = " + dasom);
//            System.out.println("cnt = " + cnt);
        }

//        System.out.println(q);
//        System.out.println(cnt);
//        System.out.println(dasom);
        System.out.println(cnt);
    }

    public static void run() {

    }
}
