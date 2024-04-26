import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int data[];
	static List<int[]> answer = new ArrayList<>();
	static boolean[] v = new boolean[10];

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
	}

	private static void run() throws Exception {
		for (int i = 1; i <= 10; i++) {
			data = new int[i];
			recur(0);
		}
		if (n > answer.size()) {
			System.out.println(-1);
		} else {
			for (int output : answer.get(n - 1)) {
				System.out.print(output);
			}
		}
	}

	private static void recur(int depth) {
		if (depth == data.length) {
			answer.add(data.clone());
			return;
		}

		if (depth == 0) {
			for (int i = 0; i <= 9; i++) {
				v[i] = true;
				data[depth] = i;
				recur(depth + 1);
				v[i] = false;
			}
		} else {
			for (int i = 0; i < data[depth - 1]; i++) {
				if (!v[i]) {
					v[i] = true;
					data[depth] = i;
					recur(depth + 1);
					v[i] = false;
				}
			}
		}
	}
}
