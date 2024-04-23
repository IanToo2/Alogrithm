import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for (int x = sx; x <= ex; x++) {
                for (int y = sy; y <= ey; y++) {
                    map[x][y] += 1;
                }
            }
        }
    }

    private static void run() {
        int answer = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (map[i][j] > m) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
