import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, k, answer;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = 0;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
			}
		}
	}

	private static void run() throws Exception {
		v[n-1][0] = true;
		dfs(n - 1, 0, 1);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int len) {

		if (len == k) {
			if (x == 0 && y == m - 1) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 'T') {
				continue;
			}
			v[nx][ny] = true;
			dfs(nx, ny, len + 1);
			v[nx][ny] = false;
		}
	}
}
