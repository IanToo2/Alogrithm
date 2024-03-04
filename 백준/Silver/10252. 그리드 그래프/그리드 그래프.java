import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int t;
	static int n, m;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			sb = new StringBuilder();
			sb.append(1).append("\n");
			init();
			run();

		}
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
	}

	public static void run() {
		//
		logic();
		// 홀, 짝 인 경우만 다른 로직
		if (n % 2 != 0 && m % 2 == 0) {
			logic3();
		} else {
			logic2();
		}
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.println(sb);
	}

	public static void logic() {
		int sx = n - 1;
		int sy = 0;
		// 0,0까지 올라가자
		while (true) {
			if (sx == 0) {
				break;
			}
			v[sx][sy] = true;
			sb.append("(").append(sx).append(",").append(sy).append(")\n");
			sx--;
		}

	}

	public static void logic2() {
//		System.out.println("로직 시작2");

		boolean check = true;

		int sx = 0;
		int sy = 0;

		while (sx < n) {
			sb.append("(").append(sx).append(",").append(sy).append(")\n");
			if (check) {
				sy++;
				if (sy == m) {
					sx++;
					sy--;
					check = false;
				}
			} else {
				sy--;
				if (sy == 0) {
					sx++;
					sy++;
					check = true;
				}
			}
		}
	}

	public static void logic3() {

		boolean check = true;

		int sx = 0;
		int sy = 0;
		while (sy < m) {

			sb.append("(").append(sx).append(",").append(sy).append(")\n");

			if (check) {
				sx--;
				if (sx < 0) {
					sx++;
					sy++;
					check = false;
				}
			} else {
				sx++;
				if (sx == n) {
					sx--;
					sy++;
					check = true;
				}
			}
		}
	}
}
