import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // -----------------------------------------------------------------------------------//
    static int k;
    static int[] data;
    static int[] answer;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                return;
            }
            data = new int[k];
            answer = new int[6];
            v = new boolean[k];

            for (int i = 0; i < k; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(data));
            run();
            System.out.println();
        }

    }

    public static void run() {
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == 6) {
//            System.out.println(Arrays.toString(answer));
            for(int output : answer){
                System.out.print(output + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!v[i]) {
                if (depth != 0 && data[i] > answer[depth - 1]) {
                    v[i] = true;
                    answer[depth] = data[i];
                    dfs(depth + 1);
                    v[i] = false;
                }else if(depth == 0){
                    v[i] = true;
                    answer[depth] = data[i];
                    dfs(depth + 1);
                    v[i] = false;
                }
            }
        }
    }
}
