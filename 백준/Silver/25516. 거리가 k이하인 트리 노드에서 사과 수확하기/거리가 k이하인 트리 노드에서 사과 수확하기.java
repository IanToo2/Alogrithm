import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n , k;
    static Node[] node;
    static boolean[] v;
    static class Node{
        int value = 0;
        List<Integer> linked = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    private static void init() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        node = new Node[n];
        for(int i = 0 ; i < n ; i++){
            node[i] = new Node();
        }
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n -1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].linked.add(v);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            node[i].value = Integer.parseInt(st.nextToken());
        }
    }
    private static void run(){
        bfs();
    }
    private static void bfs(){
        v = new boolean[n];
        Deque<int []> q = new ArrayDeque<>();
        int answer = 0;
        v[0] = true;
        q.add(new int[] {0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1] > k){
                continue;
            }
            answer += node[cur[0]].value;
            
            for(int next : node[cur[0]].linked){
                if(v[next]){
                    continue;
                }
                v[next] = true;
                q.add(new int[] {next, cur[1]+1});
            }
        }
        System.out.println(answer);

    }
}
