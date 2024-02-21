import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int[] start = new int[3];
	static int[] dictx = { -1, 1, 0, 0 };
	static int[] dicty = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 2][m + 2];
		v = new boolean[n + 2][m + 2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start[0] = i;
					start[1] = j;
					start[2] = 0;
					v[start[0]][start[1]] = true;
					map[i][j] = 0;
				}
			}
		}

		bfs();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(!v[i][j] && map[i][j]==1) {
					System.out.print("-1 ");
				}else {
					System.out.print(map[i][j] + " ");
				}
			}
            
			if (i != n) {
				System.out.println();
			}
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				if (map[cur[0] + dictx[i]][cur[1] + dicty[i]] != 0 && !v[cur[0] + dictx[i]][cur[1] + dicty[i]]) {
					map[cur[0] + dictx[i]][cur[1] + dicty[i]] = cur[2] + 1;
					q.add(new int[] { (cur[0] + dictx[i]), (cur[1] + dicty[i]), (cur[2] + 1) });
					v[cur[0] + dictx[i]][cur[1] + dicty[i]] = true;
				}
			}
		}
	}
}