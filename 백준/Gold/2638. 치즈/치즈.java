import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static Deque<int[]> cheese = new ArrayDeque<>();
    static Deque<int[]> erased = new ArrayDeque<>();

    //
    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese.add(new int[]{i, j});
                }
            }
        }
    }

    public static void run() {
        v = new boolean[n][m];
        v[0][0] = true;
        erased.add(new int[]{0, 0});
        int cnt = 0;
        while (!cheese.isEmpty()) {
//            for (int[] output : cheese) {
//                System.out.println(Arrays.toString(output));
//            }
//            System.out.println(erased);
//            printMap();
            // 초기 구역 찾기
            bfs();
            // 녹이기 시작
            erase();

            cnt++;
        }
        System.out.print(cnt);
    }

    public static void bfs() {

        while (!erased.isEmpty()) {
            int[] cur = erased.poll();
            v[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 1) continue;

                v[nx][ny] = true;
                erased.add(new int[]{nx, ny});
            }
        }
    }

    public static void erase() {
        int runCnt = cheese.size();
//        System.out.println("남은 치즈 수 : " + runCnt);
        while (runCnt-- > 0) {
            int[] cur = cheese.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (v[nx][ny]) {
                    cnt++;
                }
            }

            if (cnt < 2) {
//                System.out.println(Arrays.toString(cur) + " 생존 ");
                cheese.add(cur);
            } else {
//                System.out.println(cnt);
//                System.out.println(Arrays.toString(cur) + " 삭제 ");
                map[cur[0]][cur[1]] = 0;
                erased.add(cur);
            }
        }
//        System.out.println("지우고 남은 치즈 수 : " + cheese.size());
    }

    public static void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
