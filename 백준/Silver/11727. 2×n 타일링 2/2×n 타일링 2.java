import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		for(int i = 4 ; i < 1001;i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
		}
//		for(int i = 1 ; i < 1001;i++) {
//			System.out.println(i +"번" + dp[i]);
//		}
		System.out.println(dp[N]);
	}
}
