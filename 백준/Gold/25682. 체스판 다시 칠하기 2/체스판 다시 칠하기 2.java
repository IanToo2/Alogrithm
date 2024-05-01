import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, k;
    static int[][] whiteMap;
    static int[][] blackMap;

    public static void main(String[] args) throws Exception {
        init();
        run();
//        printMap();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        whiteMap = new int[n + 1][m + 1];
        blackMap = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                char now = input[j - 1];
                // Fill White Map
                if ((i + j) % 2 == 0 && now == 'B') {
                    whiteMap[i][j] = whiteMap[i - 1][j] + whiteMap[i][j - 1] - whiteMap[i - 1][j - 1] + 1;
                } else if ((i + j) % 2 == 1 && now == 'W') {
                    whiteMap[i][j] = whiteMap[i - 1][j] + whiteMap[i][j - 1] - whiteMap[i - 1][j - 1] + 1;
                } else {
                    whiteMap[i][j] = whiteMap[i - 1][j] + whiteMap[i][j - 1] - whiteMap[i - 1][j - 1];
                }

                // Fill Black Map
                if ((i + j) % 2 == 0 && now == 'W') {
                    blackMap[i][j] = blackMap[i - 1][j] + blackMap[i][j - 1] - blackMap[i - 1][j - 1] + 1;
                } else if ((i + j) % 2 == 1 && now == 'B') {
                    blackMap[i][j] = blackMap[i - 1][j] + blackMap[i][j - 1] - blackMap[i - 1][j - 1] + 1;
                } else {
                    blackMap[i][j] = blackMap[i - 1][j] + blackMap[i][j - 1] - blackMap[i - 1][j - 1];
                }
            }
        }
    }

    private static void run() {
        int max = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int white = cal(whiteMap,i, j);
                int black = cal(blackMap,i,j);

                int now = Math.min(white,black);
                if (max > now) {
                    max = now;
                }
            }
        }
        System.out.print(max);
    }

    private static int cal(int[][] map,int x, int y) {
        return map[x][y] + map[x - k][y - k] - map[x - k][y] - map[x][y - k];
    }

    private static void printMap() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(whiteMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
