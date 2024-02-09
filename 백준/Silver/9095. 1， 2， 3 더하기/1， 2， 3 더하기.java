import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 12; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		while (n-- > 0) {
			int input = Integer.parseInt(br.readLine());
			System.out.println(dp[input]);
		}
	}

}