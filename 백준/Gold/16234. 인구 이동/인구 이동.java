import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, l, r, cnt;
	static boolean check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
		while (!check) {
			run();
//			printMap();
		}
		System.out.println(cnt);
	}

	private static void init() throws Exception {
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	private static void run() {
		v = new boolean[n][n];
		check = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
//					System.out.println(i + "," + j + "에서 시작");
					v[i][j] = true;
					bfs(i, j);
				}
			}
		}
	}

	private static void bfs(int x, int y) {
		List<int[]> contry = new ArrayList<>();
		contry.add(new int[] { x, y });
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny])
					continue;

				int data = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
				if (l <= data && data <= r) {
					v[nx][ny] = true;
					contry.add(new int[] { nx, ny });
					q.add(new int[] { nx, ny });
				}
			}
		}

		if (contry.size() != 1) {
			if(check == true)cnt++;
			check = false;
			int sum = 0;

			for (int[] output : contry) {
				sum += map[output[0]][output[1]];
			}
			int value = sum / contry.size();
			for (int[] output : contry) {
				map[output[0]][output[1]] = value;
			}

		}
	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}