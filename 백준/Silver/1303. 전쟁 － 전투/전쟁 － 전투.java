import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, w, b;
	static int answerW, answerB;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answerW = answerB = 0;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
			}
		}
	}

	private static void run() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j]) {
					continue;
				} else {
					bfs(i, j);
				}

			}
		}
		System.out.println(answerW + " " + answerB);
	}

	private static void bfs(int x, int y) {
		char now = map[x][y];
		Deque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] { x, y });
		int cnt = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] != map[x][y]) {
					continue;
				}
				v[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
		if (now == 'W') {
			answerW += (int) Math.pow(cnt, 2);
		} else {
			answerB += (int) Math.pow(cnt, 2);
		}
	}
}
