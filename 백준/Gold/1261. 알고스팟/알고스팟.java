import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;

	static int[][] map;
	static int[][] answer;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
//		print(answer);
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(answer[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j] - '0';
			}
		}
	}

	private static void run() {
		bfs();
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[2] >= answer[cur[0]][cur[1]]) {
				continue;
			}
			answer[cur[0]][cur[1]] = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if (map[nx][ny] == 1) {
					q.add(new int[] { nx, ny, cur[2] + 1 });
				} else {
					q.add(new int[] { nx, ny, cur[2] });
				}
			}
		}
		System.out.println(answer[n - 1][m - 1]);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
