import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] data;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(answer);
    }

    public static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        run();
    }

    public static void run() {
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == N) {

            if (data[0] == 0) {
                return;
            }
//            System.out.print("check = ");
//            System.out.println(Arrays.toString(data));
            int check = 0;
            for (int i = 0; i < N; i++) {
//                System.out.println(data[N-1-i] * (int) Math.pow(10, i));
                check += data[N-1-i] * (int) Math.pow(10, i);
            }
            if(check %3==0){
                answer++;
            }
//            System.out.println("result = " + check);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0 && depth == 0) {
                continue;
            }
            data[depth] = i;
            dfs(depth + 1);
        }
    }
}
