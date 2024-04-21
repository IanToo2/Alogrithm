import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] answer = new int[6];
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map = new int[5][5];
    static boolean[] v = new boolean[10000000];

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void run() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int dept) {


        if (dept > 5) {
            int now = 0;
            for(int i = 0 ; i < 6;i++){
                now += answer[i] * (int)Math.pow(10, i);
            }
            if(!v[now]){
                v[now] = true;
                cnt++;
            }
            return;
        }
        answer[dept] = map[x][y];
//        System.out.println(x+","+y + ":" + map[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(nx, ny, dept + 1);
        }
    }
}
