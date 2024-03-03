import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, cnt;
    static char[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        init();
        logic();
//        print();
        System.out.println(cnt);
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
            }
        }
    }

    public static void logic() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    v[i][j] = true;
                    cnt++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
    }

    public static void dfs(int i, int j, char now) {
        if (now == '-') {
            int nx = i;
            int ny = j + 1;
            if (ny < m && map[nx][ny] == '-') {
                v[nx][ny] = true;
                dfs(nx, ny, now);
            }
        } else {
            int nx = i + 1;
            int ny = j;
            if (nx < n && map[nx][ny] == '|') {
                v[nx][ny] = true;
                dfs(nx, ny, now);
            }
        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}