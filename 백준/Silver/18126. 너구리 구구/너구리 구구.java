import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static long answer;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		v = new boolean[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u][v] = w;
			map[v][u] = w;
		}
	}

	private static void run() throws Exception {
		v[1] = true;
		dfs(1, 0);
		System.out.println(answer);
	}

	private static void dfs(int cur, long sum) {
		if (sum > answer) {
			answer = sum;
		}
		for (int i = 0; i <= n; i++) {
			if (!v[i] && map[cur][i] != 0) {
				v[i] = true;
				dfs(i, sum + map[cur][i]);
				v[i] = false;
			}
		}
	}
}
