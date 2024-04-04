import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, nowCnt;
	static int answer = 1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] v;
	static int maxH;
	static Deque<int[]> q;

	public static void main(String[] args) throws Exception {
		init();
		run();
		System.out.println(answer);
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxH) {
					maxH = map[i][j];
				}
			}
		}
	}

	private static void run() {
		int cnt = 1;
		while (true) {
			if (cnt == maxH)
				break;
			v = new boolean[n][n];
			nowCnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > cnt && !v[i][j]) {
						q = new ArrayDeque<>();
						q.add(new int[] { i, j });
						v[i][j] = true;
						bfs(cnt);
						nowCnt++;
					}
				}
			}
			if (nowCnt > answer) {
				answer = nowCnt;
			}
			cnt++;
		}
	}

	private static void bfs(int rain) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny] || map[nx][ny] <= rain) {
					continue;
				}

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
	}
}
