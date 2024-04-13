import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void run() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 0) continue;

                v[nx][ny] = true;

                q.add(new int[]{nx, ny});

            }
        }
    }
}
