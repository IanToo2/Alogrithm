import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	// static
	static long A, B, answer;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();

	}

	public static void init() throws Exception {

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
	}

	public static void run() {

		dfs(A, 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer + 1);
		}
	}

	public static void dfs(long cur, int cnt) {
		if (cur > B) {
			return;
		} else if (cur == B) {
			if (answer > cnt) {
				answer = cnt;
			}
			return;
		}

		dfs(cur * 10 + 1, cnt + 1);
		dfs(cur * 2, cnt + 1);

	}
}
