import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// --------------------------------------- //
	static int N;
	static int[] data;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		init();
//		print();
		run();
		
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		data = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
	}

	public static void run() {
		int max = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (data[i] > data[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	public static void print() {

	}
}