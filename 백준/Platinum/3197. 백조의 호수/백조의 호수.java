import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, endX, endY;
    static char[][] map;
    static boolean[][] check;
    static Queue<int[]> eraseQ, moveQ;
    static int[] dictX = {-1, 1, 0, 0};
    static int[] dictY = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        init();
        logic();

    }

    public static void init() throws Exception{
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        eraseQ = new LinkedList<>();
        moveQ = new LinkedList<>();

        int startX = -1, startY = -1;
        int idx = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (startX == -1 && startY == -1) {
                        startX = j;
                        startY = i;
                    } else {
                        endX = j;
                        endY = i;
                    }
                    map[i][j] = '.';
                }

                if (map[i][j] == '.') {
                    eraseQ.add(new int[]{j, i});
                }
            }
        }

        check = new boolean[R][C];
        moveQ.add(new int[]{startX, startY});
        check[startY][startX] = true;
    }
    public static void logic(){
        int cnt = 0;
        while (true) {
            if (find()) break;
            erase();
            cnt++;
        }
        System.out.print(cnt);
    }
    public static boolean find() {
        Queue<int[]> moveKeep = new LinkedList<>();

        while (!moveQ.isEmpty()) {
            int[] p = moveQ.poll();
            int px = p[0], py = p[1];
            if (px == endX && py == endY) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dictX[i];
                int ny = py + dictY[i];

                if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1 || check[ny][nx]) continue;

                check[ny][nx] = true;
                if (map[ny][nx] == '.') {
                    moveQ.add(new int[]{nx, ny});
                } else if (map[ny][nx] == 'X') { // 다음 탐색지역
                    moveKeep.add(new int[]{nx, ny});
                }
            }
        }

        moveQ = moveKeep;
        return false;
    }

    public static void erase() {
        int size = eraseQ.size();

        for (int i = 0; i < size; i++) {
            int[] p = eraseQ.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p[0] + dictX[d];
                int ny = p[1] + dictY[d];

                if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1) continue;
                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    eraseQ.add(new int[]{nx, ny});
                }
            }
        }
    }
}