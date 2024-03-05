import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] map;
	static boolean[] v;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		init();
		run();
//		print();
		System.out.println(answer);
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		v = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}

	}

	public static void run() {
		Queue<int[]> q = new LinkedList<>();
		v[1] = true;
		q.add(new int[] { 1, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[1] == 2) {
				continue;
			}
			for (int i = 1; i <= n; i++) {
				if (map[cur[0]][i] == 1 && !v[i]) {
					v[i] = true;
					q.add(new int[] { i, cur[1] + 1 });
					answer++;

				}
			}
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
