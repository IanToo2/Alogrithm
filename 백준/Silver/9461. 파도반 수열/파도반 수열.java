import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] dp;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;
		for (int i = 11; i < 101; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
//		for(long data : dp) {
//			System.out.println(data);
//		}
		while (n-- > 0) {
			int input = Integer.parseInt(br.readLine());
			System.out.println(dp[input]);
		}
	}

}