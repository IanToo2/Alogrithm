import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, maxCnt;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static char[][] map;
    static boolean[][] v;
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            init();
            logic();
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        maxCnt = n * n;
        map = new char[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (input[j] == '*') {
                    maxCnt--;
                }
                map[i][j] = input[j];
            }
        }
    }

    private static void logic() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    change(i, j);
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (v[cur[0]][cur[1]]) {
                continue;
            }
//            System.out.println("bfs : " + Arrays.toString(cur));
            bfs(cur);
        }

        sb.append(maxCnt);
    }

    private static void bfs(int[] start) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        v[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }
                maxCnt--;
                v[nx][ny] = true;
                if (map[nx][ny] == '0') {
                    dq.add(new int[]{nx, ny});
                }

            }
        }
    }

    private static void change(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != '*') {
                continue;
            }
            if (map[nx][ny] == '*') {
                cnt++;
            }
        }

        map[x][y] = (char) (cnt + '0');
        if (cnt == 0) {
            q.add(new int[]{x, y});
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
