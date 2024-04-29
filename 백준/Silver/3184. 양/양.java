import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int wolf, sheep;

	static char[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
				if (input[j] == '#') {
					v[i][j] = true;
				}
			}
		}
	}

	private static void run() {
		wolf = sheep = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j])
					continue;
				bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	private static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		int w = 0;
		int s = 0;
		v[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == 'v') {
				w++;
			} else if (map[cur[0]][cur[1]] == 'o') {
				s++;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
		if (s > w) {
			sheep += s;
		} else {
			wolf += w;
		}
	}
}
