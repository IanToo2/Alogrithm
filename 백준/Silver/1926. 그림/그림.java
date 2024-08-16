import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, picCount, maxSize;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picCount = 0;
        maxSize = 0;
        map = new int[n][m];
        v = new boolean[n][m];

        // input value
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 입력을 받으며 일부 방문처리
                if (map[i][j] == 0) {
                    v[i][j] = true;
                }
            }
        }

        logic();
        System.out.println(picCount);
        System.out.println(maxSize);
//        printMap(map);
    }

    private static void logic() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // start bfs
                if (!v[i][j]) {
                    picCount++;
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;

        q.add(new int[]{x, y});
        int size = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) {
                    continue;
                }

                v[nx][ny] = true;
                q.add(new int[]{nx, ny});

            }
        }

        maxSize = Math.max(size, maxSize);
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
