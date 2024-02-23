import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] result;
    static boolean v[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());

        while (st.countTokens() != 0) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        v = new boolean[arr.size()];
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int output : result) {
                sb.append(output).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                result[depth] = arr.get(i);
                dfs(depth + 1);
                v[i] = false;
            }
        }

    }
}