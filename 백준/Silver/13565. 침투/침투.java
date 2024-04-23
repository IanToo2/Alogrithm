import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;
	static Deque<int[]> q = new ArrayDeque<>();

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
				if (i == 0 && input[j] == '0') {
					v[i][j] = true;
					q.add(new int[] { i, j });
				} else if(input[j] == '1'){
					v[i][j] = true;
				}
			}
		}
	}

	private static void run() throws Exception {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1) {
				System.out.println("YES");
				return;
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
		System.out.println("NO");
	}
}
