
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, k;
	static int answer = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m][k+1];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j] - '0';
			}
		}
	}

	public static void run() {
		bfs();
		System.out.println(answer);
	}

	public static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, k, 1 });
		v[0][0][k] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1) {
				answer = cur[3];
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny][cur[2]])
					continue;

				if (map[nx][ny] == 1) {
					if (cur[2] != 0) {
						v[nx][ny][cur[2]] = true;
						q.add(new int[] { nx, ny, cur[2] - 1, cur[3] + 1 });
					}
				} else {
					v[nx][ny][cur[2]] = true;
					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
				}
			}
		}
	}

}
