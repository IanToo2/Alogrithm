import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, m, c, answer;
	static boolean[] v;

	static int[][] map;
	static int[][] keep;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			answer = run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());

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
		
		setMap();
	}

	private static int run() {
		int max = 0;
		// A좌표 고르기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				// B좌표 고르기
				for (int x = i; x < n; x++) {
					// 같은 행에서는 A좌표의 y값보다 더 크게
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
		return max;
	}

	private static void recur(int[] person, int[] data, int cost, int nowC) {
		// 최대로 수학 가능한 범위 = c
		if (nowC > c) {
			return;
		}
		
		// 값이 최대 인 경우
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

	// 각 좌표별 최대값을 keep에 미리 저장하는 함수
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
}
