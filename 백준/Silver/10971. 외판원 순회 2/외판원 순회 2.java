import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, map[][];
	static long total = Long.MAX_VALUE;
	static boolean v[];
	static int[] route;

	public static void main(String[] args) throws Exception {
		init();
		logic();
		System.out.println(total);
//		printMap();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N];
		route = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void logic() throws Exception {
		for (int i = 0; i < N; i++) {
			route[0] = i;
			v[i] = true;
			dfs(i, 0, 1);
			v[i] = false;

		}
	}

	public static void dfs(int now, int sum, int depth) {

		if (depth == N) {
			route[N] = route[0];
			if (map[route[N - 1]][route[0]] != 0) {
				sum += map[route[N - 1]][route[0]];
				if (sum < total) {
					total = sum;
				}
			}
//			System.out.println(Arrays.toString(route));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (map[now][i] != 0 && !v[i]) {
				v[i] = true;
				route[depth] = i;
				dfs(i, sum + map[now][i], depth + 1);
				v[i] = false;
			}
		}
	}

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printKeep() {

	}
}