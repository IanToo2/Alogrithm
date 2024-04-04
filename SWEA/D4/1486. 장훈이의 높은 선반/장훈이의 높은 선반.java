import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, b, answer;
	static int target;
	static int[] human;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		human = new int[n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			human[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void run() {
		answer = Integer.MAX_VALUE;
		recur(0, 0);
	}

	private static void recur(int sum, int idx) {
		if (sum >= target) {
//			System.out.println(sum);
			if (sum - target < answer) {
				answer = sum - target;
			}
			return;
		}

		for (int i = idx; i < n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			recur(sum + human[i], i);
			v[i] = false;
		}

	}
}
