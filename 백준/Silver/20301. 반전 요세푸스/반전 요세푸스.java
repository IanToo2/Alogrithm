import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k, m;
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
        System.out.print(sb);
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
    }

    private static void run() {
        for (int i = 0; i < k - 1; i++) {
            q.add(q.poll());
        }
        sb.append(q.poll()).append("\n");
        int cnt = 1;
        boolean check = true;
        while (!q.isEmpty()) {
            if (cnt == m) {
                cnt = 0;
                if (check) check = false;
                else check = true;
            }
            if (check) {
                for (int i = 0; i < k - 1; i++) {
                    q.add(q.poll());
                }
                sb.append(q.poll()).append("\n");
            } else {
                for (int i = 0; i < k - 1; i++) {
                    q.addFirst(q.pollLast());
                }
                sb.append(q.pollLast()).append("\n");
            }
            cnt++;

        }
    }
}
