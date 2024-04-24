import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m;
	static int[][] map;
	static Deque<int[]> q = new ArrayDeque<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
		printMap();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
				if (input[j] == 'c') {
					v[i][j] = true;
					q.add(new int[] { i, j, 0 });
				} else {
					map[i][j] = -1;
				}
			}
		}
	}

	private static void run() throws Exception {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = cur[2];

			int nx = cur[0];
			int ny = cur[1] + 1;
			if (ny >= m || v[nx][ny])
				continue;
			v[nx][ny] = true;
			q.add(new int[] { nx, ny, cur[2] + 1 });

		}
	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
}
