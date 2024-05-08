import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		init();
		floyd();
		printMap();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 98_765_432;
				}
			}
		}
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			map[u][v] = Math.min(w, map[u][v]);
		}
	}

	private static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 98_765_432) {
					System.out.print('0' + " ");
				} else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
