
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int answer;
	static boolean[] v = new boolean[12];
	static int[][] data;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			init();
			run();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		answer = Integer.MIN_VALUE;
		data = new int[12][12];
		for (int i = 1; i <= 11; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 11; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void run() throws Exception {
		recur(0, 0);
	}

	private static void recur(int depth, int sum) {
		if (depth == 11) {
			if (answer < sum) {
				answer = sum;
			}
			return;
		}
		for (int i = 1; i <= 11; i++) {
			if (!v[i] && data[i][depth+1] != 0) {
				v[i] = true;
				recur(depth + 1, sum + data[i][depth+1]);
				v[i] = false;
			}

		}
	}
}
