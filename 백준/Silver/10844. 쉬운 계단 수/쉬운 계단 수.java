import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][] dp;
	static int n;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new long[n + 1][10];
	}

	private static void run() {
		// 기본 값 세팅
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		// n번째 자리까지 계산.
		for (int i = 2; i <= n; i++) {
			// 0 ~ 9 경우의 수 계산
			for (int j = 0; j < 10; j++) {
				// 0이 가능한 경우 = 앞자리 수가 1인 경우
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % 1000000000;
				}
				// 9가 가능한 경우 = 앞자리가 8인 경우
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % 1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}

		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[n][i];
		}
		System.out.println(answer % 1000000000);
	}
}
