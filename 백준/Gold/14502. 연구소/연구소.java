import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] copy;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void run() {
        // 벽은 0인 곳에 둔다.
        // 벽을 둘 수 있는 경우를 다 탐색
        makeWall(0, 0, 0);
        System.out.println(answer);
    }

    private static void makeWall(int x, int y, int cnt) {
        if (cnt == 3) {
            logic();

            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(x,y,cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void logic() {
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
//        System.out.println("Copy");
//        printCopy();
        v = new boolean[n][m];
        // 바이러스 전파 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 2 && !v[i][j]) {
                    virusBfs(i, j);
                }
            }
        }
//        System.out.println("After Virus");
//        printCopy();
        // 영역 찾기
        int maxSize=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0 && !v[i][j]) {
                    maxSize = areaBfs(i, j,maxSize);
                }
            }
        }
        if(maxSize>answer){
            answer = maxSize;
        }
    }

    private static void virusBfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        v[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || copy[nx][ny] != 0) continue;

                copy[nx][ny] = 2;
                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    private static int areaBfs(int x, int y,int maxSize) {
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{x, y});
        v[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            maxSize++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || copy[nx][ny] != 0) continue;

                v[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return maxSize;
    }

    private static void printCopy() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
    }

}
