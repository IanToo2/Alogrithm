import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int maxValue = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] v;
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void run() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] || map[i][j] == 0) {
                    continue;
                }
//                System.out.println(cnt + "번째 시작" + i + "," + j);
                cnt++;
                bfs(i, j);
            }
        }
//        System.out.println("cnt : " + cnt);
//        System.out.println("maxValue : " + maxValue);
        System.out.println(cnt);
        System.out.println(maxValue);
    }

    public static void bfs(int x, int y) {
        v[x][y] = true;
        q.add(new int[]{x, y});
        int size = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        if (size > maxValue) {
            maxValue = size;
        }
//        System.out.println(size);
    }
}
