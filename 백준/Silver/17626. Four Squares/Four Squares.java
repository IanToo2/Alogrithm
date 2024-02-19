
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;
    static int min = 0;
    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}