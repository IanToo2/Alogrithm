import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
        
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if (i == 0) {
				dp[i][0] = Integer.parseInt(st.nextToken());
				dp[i][1] = Integer.parseInt(st.nextToken());
				dp[i][2] = Integer.parseInt(st.nextToken());
			} else {
				dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][1], dp[i - 1][2]);
				dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][0], dp[i - 1][2]);
				dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i - 1][0], dp[i - 1][1]);
			}
		}

		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
	}
}
