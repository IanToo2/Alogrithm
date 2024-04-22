import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, answer;
	static int[][] map;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = Math.max(map[i-1][j], map[i][j-1]) + value;
			}
		}
		System.out.println(map[n][m]);
	}

	private static void run() {

	}

}
