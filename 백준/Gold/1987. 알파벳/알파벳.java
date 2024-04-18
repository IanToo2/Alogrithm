import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, answer;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		v = new boolean[91];
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j];
			}
		}
//		System.out.println('A' - 0);
//		System.out.println('Z' - 0);
	}

	private static void run() {
		// 0,0 시작
		v[map[0][0] - '0'] = true;
		recur(0, 0, 1);
		System.out.println(answer);

	}

	private static void recur(int x, int y, int len) {
		if (len > answer) {
			answer = len;
		}
//		System.out.println(x+","+y + " : "+ map[x][y] + " len : " + len);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[map[nx][ny] - '0'])
				continue;
			
			v[map[nx][ny] - '0'] = true;
			recur(nx, ny, len + 1);
			v[map[nx][ny] - '0'] = false;
		}
	}
}
