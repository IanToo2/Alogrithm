import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static long[] dp;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init(){
		dp = new long[1001];
		dp[1] = 10;
		for (int i = 2; i <= 1000; i++) {
			dp[i] = dp[i-1] * (10+i-1) / i;
		}
	}

	private static void run() throws Exception{
		int t= Integer.parseInt(br.readLine());
		for(int i = 0 ; i< t; i++) {
			int idx = Integer.parseInt(br.readLine());
			System.out.println(dp[idx]);
		}
	}

}
