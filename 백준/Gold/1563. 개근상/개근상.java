import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int ans = 3;
	static int[][][] dp;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		ans=3;
		dp=new int[N+1][2][3];
		dp[1][0][0]=1;
		dp[1][0][1]=1;
		dp[1][1][0]=1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2];
			dp[i][0][1] = dp[i - 1][0][0];
			dp[i][0][2] = dp[i - 1][0][1];
			dp[i][1][0] = ans;
			dp[i][1][1] = dp[i - 1][1][0];
			dp[i][1][2] = dp[i - 1][1][1];
			ans = 0;
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] %= 1000000;
					ans += dp[i][j][k];
				}
			}
			ans %= 1000000;
		}
		System.out.println(ans);
	}
}