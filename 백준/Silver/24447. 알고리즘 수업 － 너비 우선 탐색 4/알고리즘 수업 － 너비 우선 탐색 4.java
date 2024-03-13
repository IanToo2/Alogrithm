
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, R;
    static List<TreeSet<Integer>> data = new ArrayList<>();
    static int[] answer;
    static long[] depth;
    static long sum = 0;
    static int cnt = 1;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        init();
        bfs();
        print();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            data.add(new TreeSet<>());
        }
        answer = new int[N + 1];
        depth = new long[N + 1];
        v = new boolean[N + 1];


        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data.get(u).add(v);
            data.get(v).add(u);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R, 1});
        v[R] = true;
        answer[R] = 0;
        depth[R] = cnt;
        cnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
//            System.out.println(cur[0]);
            for (int output : data.get(cur[0])) {
                if (v[output]) {
                    continue;
                }

                v[output] = true;
                answer[output] = cur[1];
                depth[output] = cnt;
                cnt++;
                q.add(new int[]{output, cur[1] + 1});
            }
        }
    }

    public static void print() {
        for (int i = 1; i <= N; i++) {
            if (v[i]) {
                sum += (depth[i] * answer[i]);
            }
        }
        System.out.println(sum);
    }
}
