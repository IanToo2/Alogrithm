import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, c, answer;
	static boolean[] v;
	static int[] personA = new int[2];
	static int[] dataA = new int[2];

	static int[] personB = new int[2];
	static int[] dataB = new int[2];

	static int[][] map;
	static int[][] keep;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		keep = new int[n][n];
		m = Integer.parseInt(st.nextToken());
		v = new boolean[m];
		c = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void run() {
		setMap();
//		printKeep();
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				// set A
				for (int x = i; x < n; x++) {
					if (x == i) {
						for (int y = j + m; y <= n - m; y++) {
							max = Math.max(max, keep[i][j] + keep[x][y]);
						}
					} else {
						for (int y = 0; y <= n - m; y++) {
							max = Math.max(max, keep[i][j] + keep[x][y]);
						}
					}
				}
			}
		}
		answer = max;
	}

	private static void recur(int[] person, int[] data, int cost, int nowC) {
		// 최대로 수학 가능한 범위 = c
		if (nowC > c) {
			return;
		}
		if (cost > data[0]) {
			data[0] = cost;
			data[1] = nowC;
		}

		for (int i = person[1]; i < person[1] + m; i++) {
			if (!v[i]) {
				v[i] = true;
				int nowValue = map[person[0]][i];
				recur(person, data, cost + (int) Math.pow(nowValue, 2), nowC + nowValue);
				v[i] = false;
			}
		}
	}

	private static void setMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				int[] now = { i, j };
				int[] data = new int[2];
				v = new boolean[n];
				recur(now, data, 0, 0);
				keep[i][j] = data[0];
			}
		}
	}

	private static void printKeep() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(keep[i][j] + " ");
			}
			System.out.println();
		}
	}
}
