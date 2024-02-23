import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();
        dfs(0, 1);
        System.out.print(sb);
    }

    static void dfs(int depth, int cur) {
        if (depth == M) {
            for(int input : arr){
                sb.append(input).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = cur; i < N + 1; i++) {
                arr[depth] = i;
                dfs(depth + 1, i + 1);
        }
    }
}