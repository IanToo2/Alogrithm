import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, answer;
	static int[] data;
	static int[] num;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
		System.out.println(answer);
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		num = new int[n];
		v = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void run() {
		recur(0);
	}

	private static void recur(int depth) {
		if (depth == n) {
			int result = cal();
			answer = Math.max(result, answer);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				num[depth] = data[i];
				v[i] = true;
				recur(depth + 1);
				v[i] = false;
			}
		}
	}

	private static int cal() {
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			result += Math.abs(num[i] - num[i + 1]);
		}
		return result;
	}
}
