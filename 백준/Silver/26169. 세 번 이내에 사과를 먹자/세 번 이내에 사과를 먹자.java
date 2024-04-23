import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer = 0;
	static boolean[][] v = new boolean[5][5];
	static int[][] map = new int[5][5];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] s = new int[2];

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		s[0] = Integer.parseInt(st.nextToken());
		s[1] = Integer.parseInt(st.nextToken());
	}

	private static void run() throws Exception {
		v[s[0]][s[1]] = true;
		dfs(s[0], s[1], 0, map[s[0]][s[1]]);
		System.out.println(answer);
	}

	private static void dfs(int x, int y, int dept, int sum) {
		if (dept == 3) {
			if (sum >= 2) {
				answer = 1;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || v[nx][ny] || map[nx][ny] == -1) {
				continue;
			}
			
			v[nx][ny] = true;
			dfs(nx, ny, dept+1, sum + map[nx][ny]);
			v[nx][ny] = false;
		}
	}
}
