import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int answer = Integer.MAX_VALUE;
	static int answeridx = Integer.MAX_VALUE;
	static ArrayList<LinkedList<Integer>> data = new ArrayList<>();
	static int[][] map;
	static boolean v[];

	public static void main(String[] args) throws Exception {
		init();

		run();

	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			data.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			map[u][v] = 1;
			map[v][u] = 1;
			data.get(u).add(v);
			data.get(v).add(u);
		}
	}

	public static void run() {
		for (int i = 1; i <= N; i++) {
			bfs(i);

		}
//		print();
//		System.out.println();
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
//			System.out.println(i + " 번 sum = " + sum + " now idx, answer = " + answeridx + " " + answer);
			if (sum < answer) {
				answer = sum;
				answeridx = i;
				
			}else if (sum==answer) {
				if(answeridx > i) {
					answeridx = i;
				}
			}
		}
//		System.out.println("idx = " + answeridx);
		System.out.println(answeridx);
	}

	public static void bfs(int start) {
		Queue<int[]> q = new LinkedList<int[]>();
		v = new boolean[N + 1];
		q.add(new int[] { start, 1 });
		v[start] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int link : data.get(cur[0])) {
				if (!v[link]) {
					if (map[start][link] == 0) {
						map[start][link] = cur[1];
					} else {
						if (map[start][link] > cur[1]) {
							map[start][link] = cur[1];
						}
					}
					v[link] = true;
					q.add(new int[] { link, cur[1] + 1 });
				}
			}
		}
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
