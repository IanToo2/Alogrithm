import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	// static
	static int N, M;
	static int cnt = Integer.MAX_VALUE;
	static int[] map = new int[101];
	static boolean[] v = new boolean[101];

	public static void main(String[] args) throws Exception {
		init();
		run();

	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 사다리
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u] = v;
		}
		// 뱀
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u] = v;
		}
//		System.out.println();
//		System.out.println(Arrays.toString(map));
	}

	public static void run() {
		bfs();
		System.out.println(cnt);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });
		v[1] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(cur[0] + " " + cur[1]);
			if (cur[0] == 100) {
				if (cnt > cur[1]) {
					cnt = cur[1];
				}
			}

			for (int i = 1; i < 7; i++) {
				int nc = cur[0] + i;

				// 범위 밖인 경우
				if (nc > 100 || v[nc]) {
					continue;
				}
				if(v[nc]) {
					continue;
				}
				if (map[nc] != 0) {
					// 사다리 타는 경우
					if (map[nc] > nc) {
//						System.out.println(nc + " --> " + map[nc]);
//						System.out.println("사다리 타기");
						
						
						v[nc]=true;
						v[map[nc]]=true;
						nc = map[nc];
						q.add(new int[] { nc , cur[1] + 1 });
					}
					// 뱀을 만난 경우
					else if (map[nc] < nc) {
						v[nc]=true;
						v[map[nc]]=true;
						nc = map[nc];
						q.add(new int[] { nc , cur[1] + 1 });
					}
				} else {
					v[nc] = true;
					q.add(new int[] { nc, cur[1] + 1 });
				}
			}
		}
	}

//	public static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}
