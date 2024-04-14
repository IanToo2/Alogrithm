import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static Deque<int[]> ice = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
//        printV();
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
                if (map[i][j] != 0) {
                    ice.add(new int[]{i, j});
                }
            }
        }
    }

    private static void run() {
        // 첫 행과 마지막 행을 시작으로 공기 확인
        addAir(0, 0);
        int time = 0;
        int cnt = 0 ;
        while(!ice.isEmpty()){
            if(checkLand()){
                time = cnt;
                break;
            }
            cnt++;
            meltIce();
//            System.out.println(cnt);
//            printMap();

        }
        System.out.println(time);
    }
    private static boolean checkLand(){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] nowV = new boolean[n][m];

        int[] input = ice.poll();
        ice.addFirst(input);
        nowV[input[0]][input[1]] = true;
        q.add(input);
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(map[nx][ny] != 0 && !nowV[nx][ny]){
                    nowV[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }

        if(cnt == ice.size()){
            return false;
        }else{
//            System.out.println("now cnt : " + cnt);
//            System.out.println("now iceSize : " + ice.size());
            return true;
        }
    }
    private static void meltIce() {
        int[][] keep = new int[n][m];
        int iceCnt = ice.size();
        for (int i = 0; i < iceCnt; i++) {
            int[] cur = ice.poll();
            int size = 0;
            for (int j = 0; j < 4; j++) {
                int nx = cur[0] + dx[j];
                int ny = cur[1] + dy[j];
                if (map[nx][ny] == 0) {
                    size++;
                }
            }
            int nValue = map[cur[0]][cur[1]] - size;
            if (nValue <= 0) {
                keep[cur[0]][cur[1]] = 0;
                v[cur[0]][cur[1]] = true;
            } else {
                keep[cur[0]][cur[1]] = nValue;
                ice.add(cur);
            }
        }
        map = keep;
    }

    private static void addAir(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) continue;
                if (map[nx][ny] == 0) {
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void printV() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void printMap(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
