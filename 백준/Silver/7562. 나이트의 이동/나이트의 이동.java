import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int len;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            len = Integer.parseInt(br.readLine());
            map = new int[len][len];
            v = new boolean[len][len];

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            run();
        }
        System.out.println(sb);
    }

    public static void run() {

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 0});
        v[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                sb.append(cur[2]).append("\n");
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= len || ny >= len || v[nx][ny]) {
                    continue;
                }

                q.add(new int[]{nx, ny, cur[2] + 1});
                v[nx][ny] = true;
            }
        }
    }
}
