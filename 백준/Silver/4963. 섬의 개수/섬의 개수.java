import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n = -1;
    static int m = -1;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        while (true) {
            init();
            if(m == 0 && n == 0){
                break;
            }
            run();
        }
        System.out.println(sb);
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        if(n == 0 && m == 0) return;
        map = new int[n][m];
        v = new boolean[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 0) {
                    v[x][y] = true;
                }
            }
        }
    }

    private static void run() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (!v[i][j]) {
                    bfs(i,j);
                    cnt++;
                }
        }
//        System.out.println(cnt);
        sb.append(cnt).append("\n");
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

    }
}
