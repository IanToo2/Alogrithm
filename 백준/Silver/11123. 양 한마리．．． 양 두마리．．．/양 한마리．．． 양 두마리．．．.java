import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer, n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] v;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            run();
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        answer = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
            }
        }
    }

    private static void run() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] == '#') {
                    bfs(i, j);
                    answer++;
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == '.') continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

}
