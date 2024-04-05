import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            init();
            run();
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception {
        answer = Integer.MAX_VALUE;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        v = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j] - '0';
            }
        }
    }

    private static void run() {
        bfs();
    }

    private static void bfs() {
        // 시작 0,0
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });
        v[0][0] = true;
        q.add(new int[]{0, 0,map[0][0]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            v[cur[0]][cur[1]] = true;

            // 도착시 답 갱신
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                if (answer > cur[2]) {
                    answer = cur[2];
                }
            }
            // 불필요한 연산 제외
            if (cur[2] > answer) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny]) continue;
                if(cur[2] + map[nx][ny] > answer) continue;
                
                q.add(new int[]{nx, ny, cur[2] + map[nx][ny]});
            }
        }
    }
}
