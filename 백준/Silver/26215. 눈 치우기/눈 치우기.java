import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void run() {
        int cnt = 0;
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                int first = q.poll() - 1;
                if (first != 0) {
                    q.add(first);
                }
            } else {
                int first = q.poll() - 1;
                int second = q.poll() - 1;
                if (first != 0) {
                    q.add(first);
                }
                if (second != 0) {
                    q.add(second);
                }
            }
            cnt++;
            if (cnt == 1441) {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
