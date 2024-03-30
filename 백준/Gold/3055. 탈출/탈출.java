import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    static int answer = -1;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean fail;
    static boolean[][] v;
    static Deque<int[]> animalQ = new ArrayDeque<>();
    static Deque<int[]> waterQ = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        v = new boolean[R][C];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if (input[j] == 'D') {
                    end[0] = i;
                    end[1] = j;
                } else if (input[j] == 'S') {
                    map[i][j] = '.';
                    start[0] = i;
                    start[1] = j;
                } else if (input[j] == '*') {
                    waterQ.add(new int[]{i, j});
                    v[i][j] = true;
                } else if (input[j] == 'X'){
                    v[i][j] = true;
                }
            }
        }
    }

    public static void run() {
        // 고슴도치 -> 물
        v[start[0]][start[1]] = true;
        animalQ.add(new int[]{start[0], start[1], 0});
        while (!animalQ.isEmpty()) {
            if (fail) {
                break;
            }
            animal();
            water();
//            printMap();
//            System.out.println();
        }
        if (answer == -1) {
            System.out.print("KAKTUS");
        }
    }

    public static void animal() {
        Deque<int[]> keep = new ArrayDeque<>();
        while (!animalQ.isEmpty()) {
            int[] cur = animalQ.poll();
            if (map[cur[0]][cur[1]] == '*') {
                continue;
            }
            if (map[cur[0]][cur[1]] == 'D') {
                answer = cur[2];
                System.out.print(cur[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || v[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;

                if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
                    v[nx][ny] = true;
                    keep.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        animalQ = keep;
    }

    public static void water() {
        Deque<int[]> keep = new ArrayDeque<>();
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || !(map[nx][ny] == '.')) {
                    continue;
                }

                map[nx][ny] = '*';
                keep.add(new int[]{nx, ny});
            }
        }
        waterQ = keep;
    }

    public static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
