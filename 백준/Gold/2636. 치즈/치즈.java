import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int cheezeCnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static Deque<int[]> cheeze = new ArrayDeque<>();
    static Deque<int[]> eq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
//        printV();
//        System.out.println("로직시작");
        run();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeze.add(new int[]{i, j});
                    cheezeCnt++;
                }
            }
        }

        // 초기 공기 세팅
        Deque<int[]> q = new ArrayDeque<>();
        v[0][0] = true;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] != 0) continue;
                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    private static void run() {
        int cnt = 0;
        while (true) {
            findCheeze();

            if (cheezeCnt - eq.size() != 0) {
                cheezeCnt -= eq.size();
            }else if(cheezeCnt-eq.size() == 0){
                cnt++;
                break;
            }
            eraseCheeze();
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(cheezeCnt);

    }

    private static void findCheeze() {
        Deque<int[]> keep = new ArrayDeque<>();
        while (!cheeze.isEmpty()) {
            int[] cur = cheeze.poll();
            boolean check = false;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (v[nx][ny]) {
                    eq.add(cur);
                    check = true;
                    break;
                }
            }
            if (!check) {
                keep.add(cur);
            }
        }
        cheeze = keep;
    }

    private static void eraseCheeze() {
        while (!eq.isEmpty()) {
            int[] cur = eq.poll();
            v[cur[0]][cur[1]] = true;
            map[cur[0]][cur[1]] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (v[nx][ny] || map[nx][ny] == 1) continue;
                v[nx][ny] = true;
                eq.add(new int[]{nx, ny});
            }

        }
    }
}

