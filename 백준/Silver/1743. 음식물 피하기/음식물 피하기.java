import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        answer = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

    }

    private static void run() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 0) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        if (answer < cnt) {
            answer = cnt;
        }
    }

}
