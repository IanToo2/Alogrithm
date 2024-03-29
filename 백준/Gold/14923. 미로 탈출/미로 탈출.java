import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    //

    static int n, m, answer;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] v;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken()) - 1;
        start[1] = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken()) - 1;
        end[1] = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void run() {
        v = new boolean[n][m][2];
        answer = Integer.MAX_VALUE;
        bfs();
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.print(answer);
        }
    }

    public static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        v[start[0]][start[1]][1] = true;
        q.add(new int[]{start[0], start[1], 1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[3] > answer) {
                continue;
            }

//            System.out.println(Arrays.toString(cur));
            if (cur[0] == end[0] && cur[1] == end[1]) {
                answer = cur[3];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny][cur[2]]) continue;

                if (map[nx][ny] == 0) {
                    v[nx][ny][cur[2]] = true;
                    q.add(new int[]{nx, ny, cur[2], cur[3] + 1});
                } else {
                    if (cur[2] == 1) {
                        v[nx][ny][cur[2]] = true;
                        q.add(new int[]{nx, ny, 0, cur[3] + 1});
                    } else {
                        continue;
                    }
                }

            }
        }
    }
}
