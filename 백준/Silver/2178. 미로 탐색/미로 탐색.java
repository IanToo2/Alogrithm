import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] v;
	static int N, M;
	static int[] dictx = { -1, 1, 0, 0 };
	static int[] dicty = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		init();
		bfs();
	}

	public static void init() throws Exception {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		v = new boolean[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { 1, 1, 0 });
		v[1][1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N && cur[1] == M) {
				System.out.println(cur[2]+1);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = cur[0] + dictx[i];
				int nextY = cur[1] + dicty[i];

				if (map[nextX][nextY] == 1 && 0 < nextX && nextX <= N && 0 < nextY && nextY <= M && !v[nextX][nextY]) {
					q.add(new int[] { nextX, nextY, (cur[2] + 1) });
					v[nextX][nextY] = true;
//					System.out.println(nextX + "," + nextY +" = "+ (cur[2]+1));
				}

			}

		}

	}
}