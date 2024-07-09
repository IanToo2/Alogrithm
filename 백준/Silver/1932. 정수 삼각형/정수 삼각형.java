import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int[][] data = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = data[1][1];
        // dp
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = data[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

//        print(dp);
        int answer = 0;
        for(int output : dp[n]){
            answer = Math.max(answer, output);
        }
        System.out.println(answer);
    }

    private static void print(int[][] data) {
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(data[i]));
        }

    }
}
