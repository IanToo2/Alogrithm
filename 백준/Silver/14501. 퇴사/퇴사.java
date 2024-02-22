import java.io.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	// 상담수, 가격
	static int T[], P[];
	static int dp[];

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		T = new int[N];
		P = new int[N];
		dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void run() {
		for (int i = 0; i < N; i++) {
			if (i + T[i] <= N) {
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			} // if
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);

		} // for
		System.out.println(dp[N]);
	}
}