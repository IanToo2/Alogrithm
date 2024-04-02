import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws Exception {
        int cnt = 1;
        while (true) {

            init();
            if (n == 0) {
                break;
            }
            answer = Integer.MAX_VALUE;
            run();

            sb.append("Problem ").append(cnt).append(": ").append(answer).append("\n");
            cnt++;
        }
        System.out.print(sb);
    }

    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            return;
        }
        map = new int[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void run() {
        bfs();
    }

    public static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });

        v[0][0] = true;
        q.add(new int[]{0, 0, map[0][0]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                if (answer > cur[2]) {
                    answer = cur[2];
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny]) continue;

                if (cur[2] + map[nx][ny] > answer) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + map[nx][ny]});
            }

        }
    }
}
