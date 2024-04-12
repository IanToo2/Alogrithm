import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static boolean[] v;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		init();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			sb.append(run(s, e)).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[u - 1][v - 1] = value;
			map[v - 1][u - 1] = value;
		}
	}

	private static int run(int start, int end) {
		v = new boolean[n];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { start, 0 });
		v[start] = true;
//		System.out.println(start + " - > " + end);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			if (cur[0] == end) {
				return cur[1];
			}
			for (int i = 0; i < n; i++) {
				if (map[cur[0]][i] != 0 && !v[i]) {
					v[i] = true;
					q.add(new int[] { i, cur[1] + map[cur[0]][i] });
				}
			}
		}
		return 0;

	}

}
