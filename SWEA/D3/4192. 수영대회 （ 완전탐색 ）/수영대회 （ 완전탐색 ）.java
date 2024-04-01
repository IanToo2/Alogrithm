import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] s, e;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            init();
            sb.append("#").append(i).append(" ").append(run()).append("\n");
        }
        System.out.println(sb);
    }

    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        v = new boolean[n][n];
        s = new int[2];
        e = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        s[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        e[0] = Integer.parseInt(st.nextToken());
        e[1] = Integer.parseInt(st.nextToken());
    }

    public static int run() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s[0], s[1], 0});
        v[s[0]][s[1]] = true;
        int nowAnswer = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == e[0] && cur[1] == e[1]) {
                nowAnswer = cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny] || map[nx][ny] == 1) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return nowAnswer;
    }
}
