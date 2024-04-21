import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    private static void init() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = input[j];
            }
        }
    }
    private static void run(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    private static void bfs(int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        v = new boolean[n][m];
        q.add(new int [] {x,y,0});
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if (answer < cur[2]){
                answer = cur[2];
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) continue;

                if(map[nx][ny] == 'L'){
                    v[nx][ny] = true;
                    q.add(new int [] {nx, ny, cur[2] + 1});
                }
            }
        }
    }

}
