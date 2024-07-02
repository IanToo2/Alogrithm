import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        BigInteger[] dp = new BigInteger[81];
        dp[1] = BigInteger.valueOf(4);
        dp[2] = BigInteger.valueOf(6);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n > 1) {
            for (int i = 3; i <= n; i++) {
                dp[i] =  dp[i-1].add(dp[i-2]);
            }
        }
        System.out.println(dp[n]);
    }
}