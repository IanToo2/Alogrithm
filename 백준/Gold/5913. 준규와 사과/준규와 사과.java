import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// --------------------------------------- //;
	static int K, answer;

	static int[][] map = new int[5][5];
	static boolean[][] v = new boolean[5][5];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
//		print();
	}

	public static void init() throws Exception {
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			v[x - 1][y - 1] = true;

		}
	}

	public static void run() {
		v[0][0] = true;
		dfs(0, 0, K+1);
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int cnt) {
		if (x == 4 && y == 4) {
			if (cnt == 25) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || v[nx][ny]) {
				continue;
			}
			v[nx][ny] = true;
//			System.out.println(cnt);
			dfs(nx, ny, cnt + 1);
			v[nx][ny] = false;
		}

	}

	public static void print() {
	}
}