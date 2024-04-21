import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] v;
    static Deque<int[]> person;
    static Deque<int[]> fire;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        person = new ArrayDeque<>();
        fire = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'J') {
                    v[i][j] = true;
                    person.add(new int[]{i, j, 0});
                } else if (map[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }
            }
        }
    }

    private static void run() {
        while (true) {
            //  person Move
            if (personMove()) {
                return;
            }
            if (person.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            // fire Move
            fireMove();
        }
    }

    private static boolean personMove() {
        int size = person.size();
        for (int i = 0; i < size; i++) {
            int[] cur = person.poll();
            if (map[cur[0]][cur[1]] == 'F') {
                continue;
            }
            for (int j = 0; j < 4; j++) {
                int nx = cur[0] + dx[j];
                int ny = cur[1] + dy[j];

                //  탈출하는 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    System.out.println(cur[2] + 1);
                    return true;
                }
                if (map[nx][ny] == '.' && !v[nx][ny]) {
                    v[nx][ny] = true;
                    person.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return false;
    }

    private static void fireMove() {
        int size = fire.size();
        for (int i = 0; i < size; i++) {
            int[] cur = fire.poll();
            for(int j = 0 ; j< 4 ; j++){
                int nx = cur[0] + dx[j];
                int ny = cur[1] + dy[j];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;

                map[nx][ny] = 'F';
                fire.add(new int [] {nx, ny});
            }
        }
    }
}
