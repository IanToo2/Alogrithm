import java.io.*;
import java.util.*;

public class Main {
	static int r, c, s, w;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		s = 0;
		w = 0;
		map = new char[r][c];
		v = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = input[j];
			}
		}
	}

	private static void run() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (v[i][j] || map[i][j] == '#') {
					continue;
				}
				bfs(i, j);
			}
		}
		System.out.print(s + " " + w);
	}

	private static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		int nowS = 0;
		int nowW = 0;

		v[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (map[cur[0]][cur[1]] == 'v') {
				nowW++;
			} else if (map[cur[0]][cur[1]] == 'k') {
				nowS++;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '#' || v[nx][ny]) {
					continue;
				}

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
		if(nowS > nowW) {
			s += nowS;
		}else {
			w += nowW;
		}
	}
}
