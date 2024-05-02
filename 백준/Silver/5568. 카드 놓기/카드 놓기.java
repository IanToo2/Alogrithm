import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, k;
	static char[] data;
	static int[] num;
	static Set<Integer> set = new HashSet<>();
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		data = new char[n];
		v = new boolean[n];
		k = Integer.parseInt(br.readLine());
		num = new int[k];
		for (int i = 0; i < n; i++) {
			data[i] = (char) Integer.parseInt(br.readLine());
		}

	}

	private static void run() {
		recur(0);
		System.out.println(set.size());
	}

	private static void recur(int depth) {
		if (depth == k) {
			String result = "";
			for (int i = 0; i < k; i++) {
				result += num[i];
			}
			set.add(Integer.parseInt(result));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			num[depth] = data[i];
			recur(depth + 1);
			v[i] = false;
		}
	}
}
