import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] data;
	static char[] input;
	static boolean[] v;
	static int n;
	static List<int[]> answer = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		input = new char[n];
		data = new int[n + 1];
		v = new boolean[10];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = st.nextToken().charAt(0);
		}
	}

	private static void run() throws Exception {
		dfs(0);

		for (int output : answer.get(answer.size() - 1)) {
			System.out.print(output);
		}
		System.out.println();
		for (int output : answer.get(0)) {
			System.out.print(output);
		}

	}

	private static void dfs(int depth) {
		if (depth == n + 1) {
			answer.add(data.clone());
//			for (int output : data) {
//				System.out.print(output);
//			}
//			System.out.println();
			return;
		}

		if (depth == 0) {
			for (int i = 0; i < 10; i++) {
				data[depth] = i;
				v[i] = true;
				dfs(depth + 1);
				v[i] = false;
			}
		} else {
			if (input[depth - 1] == '<') {
				for (int i = 0; i <= 9; i++) {
					if (i > data[depth - 1] && !v[i]) {
						data[depth] = i;
						v[i] = true;
						dfs(depth + 1);
						v[i] = false;
					}
				}
			} else {
				for (int i = 0; i <= 9; i++) {
					if (i < data[depth - 1] && !v[i]) {
						data[depth] = i;
						v[i] = true;
						dfs(depth + 1);
						v[i] = false;
					}
				}
			}
		}
	}
}
