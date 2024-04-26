import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, k;

	static int[] horseX = { -2, -1, 1, 2, 2, 1, -1, -1 };
	static int[] horseY = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[][] map;
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[31][n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void run() throws Exception {
		v[0][0][0] = true;
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1) {
				System.out.println(cur[2]);
				return;
			}

			// 말로 움직임 확인
			if (cur[3] < k) {
				for (int i = 0; i < 8; i++) {
					int nx = cur[0] + horseX[i];
					int ny = cur[1] + horseY[i];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[cur[3]+1][nx][ny] || map[nx][ny] == 1)
						continue;

					v[cur[3]+1][nx][ny] = true;
					q.add(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
				}
			}
			// 4방위 확인
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[cur[3]][nx][ny] || map[nx][ny] == 1)
					continue;

				v[cur[3]][nx][ny] = true;
				q.add(new int[] { nx, ny, cur[2] + 1, cur[3] });
			}
		}
		System.out.println(-1);
	}
}
