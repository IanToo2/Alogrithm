import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, t, answer;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
//		printMap();
		change();
//		printMap();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int avg = 0;
				for (int k = 0; k < 3; k++) {
					avg += Integer.parseInt(st.nextToken());
				}
				map[i][j] = avg / 3;
			}
		}

		t = Integer.parseInt(br.readLine());

	}

	private static void run() throws Exception {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j] && map[i][j] == 1) {
					v[i][j] = true;
					answer++;
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	private static void change() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= t) {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 0)
					continue;

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });

			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
