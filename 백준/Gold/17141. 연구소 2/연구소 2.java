import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, size, answer;
	static int[] cases;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] v;
	static List<int[]> virus = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		v = new boolean[n][n];

		m = Integer.parseInt(st.nextToken());
		cases = new int[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					v[i][j] = true;
				} else if (value == 2) {
					size++;
					virus.add(new int[] { i, j });
				} else {
					size++;
				}
				map[i][j] = value;
			}
		}

	}

	private static void run() {
//		System.out.println(size);
		// 바이러스를 배치할 수 있는 경우의 수
		recur(0);
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static void recur(int depth) {
		if (depth == m) {
//			System.out.println(Arrays.toString(cases));
			// 번식 시작
			int[] nowCase = cases.clone();
			bfs(nowCase);
			return;
		}

		if (depth == 0) {
			for (int i = 0; i < virus.size(); i++) {
				cases[depth] = i;
				recur(depth + 1);
			}
		} else {
			for (int i = cases[depth - 1] + 1; i < virus.size(); i++) {
				cases[depth] = i;
				recur(depth + 1);
			}
		}
	}

	private static void bfs(int[] nowCase) {
		boolean[][] copyV = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			copyV[i] = v[i].clone();
		}
		// 바이러스가 퍼지는 장소의 수
		int cnt = m;
		int maxTime = 0;
		Deque<int[]> q = new ArrayDeque<>();

		for (int output : nowCase) {
			copyV[virus.get(output)[0]][virus.get(output)[1]] = true;
			q.add(new int[] { virus.get(output)[0], virus.get(output)[1], 0 });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[2] > maxTime) {
				maxTime = cur[2];
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || copyV[nx][ny])
					continue;

				copyV[nx][ny] = true;
				cnt++;
				q.add(new int[] { nx, ny, cur[2] + 1 });
			}
		}
//		System.out.println(cnt);
//		System.out.println(maxTime);
		if (cnt == size && maxTime < answer) {
//			System.out.println("성공");
			answer = maxTime;
		}
	}
}
