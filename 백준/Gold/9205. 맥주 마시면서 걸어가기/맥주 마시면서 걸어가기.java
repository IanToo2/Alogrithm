import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] s;
    static int[] e;
    static boolean[] v;
    static Store[] store;

    static class Store {
        int x;
        int y;
        boolean check;

        @Override
        public String toString() {
            return "Store{" +
                    "x=" + x +
                    ", y=" + y +
                    ", check=" + check +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            run();
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        s = new int[2];
        e = new int[2];

        n = Integer.parseInt(br.readLine());
        v = new boolean[n];
        store = new Store[n];

        // 출발지
        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        s[1] = Integer.parseInt(st.nextToken());

        // 편의점 정보
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            store[i] = new Store();
            store[i].x = Integer.parseInt(st.nextToken());
            store[i].y = Integer.parseInt(st.nextToken());
        }

        // 도착지
        st = new StringTokenizer(br.readLine());
        e[0] = Integer.parseInt(st.nextToken());
        e[1] = Integer.parseInt(st.nextToken());
    }

    private static void run() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {s[0], s[1]});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(Math.abs(e[0] - cur[0]) + Math.abs(e[1] - cur[1]) <= 1000){
                sb.append("happy\n");
                return;
            }
            for(int i = 0 ; i < n ; i++){
                if(!store[i].check && Math.abs(store[i].x - cur[0]) + Math.abs(store[i].y - cur[1]) <= 1000){
                    store[i].check = true;
                    q.add(new int [] {store[i].x, store[i].y});
                }
            }
        }
        sb.append("sad\n");
    }
}
