import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int[] dp = new int [1001];

	public static void main(String[] args) throws IOException {
		// 1~1000
		N = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[N]);

	}
}