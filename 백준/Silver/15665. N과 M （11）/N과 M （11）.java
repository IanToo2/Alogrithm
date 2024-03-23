import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static List<Integer> data = new ArrayList<>();
    static int[] result;
    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int input = Integer.parseInt(st.nextToken());
            if(data.contains(input)){
                continue;
            }

            data.add(input);
        }
        Collections.sort(data);
        run();
        System.out.print(sb);
    }

    public static void run() {
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == M){
            for(int i = 0 ; i < M;i ++){
                if(i == M-1){
                    sb.append(result[i]).append("\n");
                }else{
                    sb.append(result[i]).append(" ");
                }
            }

            return;
        }

        for(int i = 0 ; i < data.size();i++){
            result[depth] = data.get(i);
            dfs(depth +1);
        }
    }
}
