import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int m, n, k;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] v;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static Deque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		init();
//		printMap();
		run();
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			int output = pq.poll();
			System.out.print(output + " ");
		}
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		v = new boolean[m][n];
		for (int i = 0; i < k; i++) {
//			System.out.println("사각형 그리기");
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
//			System.out.println(x1 + "," + y1 + "," + x2 + "," + y2);
			for (int x = m - y2; x < m - y1; x++) {
				for (int y = x1; y < x2; y++) {
//					System.out.println(x + "," + y);
					map[x][y] = 1;
					v[x][y] = true;
				}
			}
		}
	}

	private static void run() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && !v[i][j]) {
					bfs(i, j);
				}
			}
		}
	}

	private static void bfs(int x, int y) {
		v[x][y] = true;
		q.add(new int[] { x, y });
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n || v[nx][ny] || map[nx][ny] == 1)
					continue;

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });

			}
		}
//		System.out.println("return cnt : " + cnt);
		pq.add(cnt);
	}

	private static void printMap() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
