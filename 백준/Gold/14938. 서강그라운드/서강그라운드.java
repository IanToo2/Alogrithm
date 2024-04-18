import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, r, answer;
	static int[] item;
	static int[][] map;
	static int[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		item = new int[n + 1];
		map = new int[n + 1][n + 1];
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		// item
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		// map
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u][v] = w;
			map[v][u] = w;
		}
	}

	private static void run() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
//			System.out.println(i+"번 시작");
			list.add(bfs(i));
		}
		Collections.sort(list, Collections.reverseOrder());

		System.out.println(list.get(0));
	}

	private static int bfs(int start) {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		v = new int[n + 1];
		Arrays.fill(v, Integer.MAX_VALUE);
		int items = 0;
		// 위치, 거리 합
		v[start] = 0;
		q.add(new int[] { start, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			// 거리가 더 먼 경우 pass
			if (v[cur[0]] < cur[1])
				continue;

			for (int i = 1; i <= n; i++) {
				if (map[cur[0]][i] != 0) {
					if (v[i] > cur[1] + map[cur[0]][i]) {
						v[i] = cur[1] + map[cur[0]][i];
						q.add(new int[] { i, cur[1] + map[cur[0]][i] });
					}
				}
			}
		}
//		System.out.println(Arrays.toString(v));
		for(int i = 1; i <= n ; i++) {
			if(v[i] <= m ) {
				items += item[i];
			}
		}
		
		return items;
	}

	private static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
