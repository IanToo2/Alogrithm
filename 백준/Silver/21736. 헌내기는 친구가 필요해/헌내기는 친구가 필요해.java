import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, sx, sy, cnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
				if (input[j] == 'I') {
					sx = i;
					sy = j;
				}
			}
		}
	}

	public static void run() {
		bfs();
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy });
		v[sx][sy] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 'X') {
					continue;
				} else if (map[nx][ny] == 'P') {
					cnt++;
				}

				q.add(new int[] { nx, ny });
				v[nx][ny] = true;
			}
		}
	}

}
