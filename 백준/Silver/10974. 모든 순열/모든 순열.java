import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] data;
	static int[] num;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n + 1];
		data = new int[n];
		v = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			num[i] = i;
		}
	}

	private static void run() {
		recur(0);
	}

	private static void recur(int depth) {
		if (depth == n) {
			for (int output : data) {
				System.out.print(output + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!v[i]) {
				v[i] = true;
				data[depth] = i;
				recur(depth + 1);
				v[i] = false;
			}
		}
	}
}
