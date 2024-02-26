import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] v;
	static int n;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		v = new boolean[n + 1];
		int inputCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < inputCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}

//		for (int x = 0; x < n+1; x++) {
//			for (int y = 0; y < n+1; y++) {
//				System.out.print(map[x][y] + " ");
//			}
//			System.out.println();
//		}
		bfs();
		System.out.println(cnt);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		v[1] = true;
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 1; i < n+1; i++) {
				if (map[idx][i] == 1 && !v[i]) {
					v[i] = true;
//					System.out.println("input data = " + i);
					q.offer(i);
					cnt += 1;
				}
			}
		}
	}
}