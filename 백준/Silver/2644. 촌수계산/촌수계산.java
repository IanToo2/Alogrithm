import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,s,e;
    static boolean[] v;
    static int[][] map;
    static int answer = -1;

    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    public static void init() throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        v = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }


    }
    public static void run(){
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s, 0});
        v[s] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == e){
                answer = cur[1];
            }
            for(int i = 1; i < N+1 ; i++){
                if(v[i] || map[cur[0]][i] == 0) continue;

                q.add(new int[] {i, cur[1] + 1});
                v[i] = true;
            }
        }
    }

}
