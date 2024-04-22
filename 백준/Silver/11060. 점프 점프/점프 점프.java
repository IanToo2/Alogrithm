import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static boolean[] v;
	static int[] data;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		v = new boolean[n];
		data = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void run() {
		bfs();
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		v[0] = true;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1) {
				System.out.println(cur[1]);
				return;
			}

			for (int i = 0; i <= data[cur[0]]; i++) {
				int nx = cur[0] + i;
				if (nx < n && !v[nx]) {
					v[nx]=true;
					q.add(new int[] { nx, cur[1] + 1 });
				}
			}
		}
		System.out.println(-1);
	}
}
