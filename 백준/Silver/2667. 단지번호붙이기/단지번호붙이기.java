import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	// static
	static int N;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];
				if (input[j] == '0') {
					v[i][j] = true;
				}
			}
		}

	}

	public static void run() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					continue;
				}
				cnt++;
				bfs(i, j);
			}
		}
		System.out.println(cnt);
		Collections.sort(answer);
		for (int output : answer) {
			System.out.println(output);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, 1 });
		v[x][y] = true;
		int max = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || ny >= N || nx >= N || v[nx][ny]) {
					continue;
				}

				v[nx][ny] = true;
				max++;
				q.add(new int[] { nx, ny, cur[2] + 1 });
			}
		}
		answer.add(max);

	}
}
