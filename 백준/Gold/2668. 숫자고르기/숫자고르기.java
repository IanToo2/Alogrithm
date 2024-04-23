import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static boolean[] v;
	static int[] data;
	static List<Integer> answer = new ArrayList<>();
	

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		v = new boolean[n + 1];
		data = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void run() {
		for (int i = 1; i <= n; i++) {
			v[i] = true;
			dfs(i, i);
			v[i] = false;

		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int output : answer) {
			System.out.println(output);
		}
	}

	private static void dfs(int cur, int target) {
		if (data[cur] == target) {
			answer.add(cur);
			return;
		}
		if (!v[data[cur]]) {
			v[data[cur]] = true;
			dfs(data[cur], target);
			v[data[cur]] = false;
		}
	}
}
