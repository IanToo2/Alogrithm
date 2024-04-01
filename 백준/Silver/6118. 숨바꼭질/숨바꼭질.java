import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int len = 0;
    static int firstNode;
    static ArrayList<Integer> answer = new ArrayList<>();
    static List<Integer>[] data;

    public static void main(String[] args) throws Exception {
        init();
        run();
//        print();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        data = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            data[i] = new ArrayList<>();
        }
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            data[u].add(v);
            data[v].add(u);
        }
    }

    public static void run() {
        bfs();
        System.out.print(Collections.min(answer) + " " + len + " " + answer.size());
//        System.out.println(answer);
//        System.out.println(len);
    }


    public static void bfs() {
        // start = 1
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[n + 1];

        q.add(new int[]{1, 0});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            if(cur[1] > len) {
                answer = new ArrayList<>();
                answer.add(cur[0]);
                len = cur[1];
            }else if ( cur[1] == len){
                answer.add(cur[0]);
            }

//            System.out.println("Linked");
            for (int linked : data[cur[0]]) {
//                System.out.println(linked);
                if (v[linked]) continue;
                v[linked] = true;
                q.add(new int[]{linked, cur[1] + 1});
            }
        }
    }
    public static void print(){
        for(int i = 1; i <= n ; i++){
            System.out.println("index : " + i);
            for(int output : data[i]){
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }
}
