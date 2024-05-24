
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans;
	static int[][] map;
	static boolean[][] v;
	static boolean pick;
	// 8방 탐색
	static int dx[] = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int dy[] = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j]) {
					pick = true;
					dfs(i, j);
					if (pick) {
						ans++;
					}
				}
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		v[x][y] = true;
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			if (map[nx][ny] > map[x][y]) {
				pick = false;
			}
			if (!v[nx][ny] && map[nx][ny] == map[x][y]) {
				dfs(nx, ny);
			}
		}
	}

}