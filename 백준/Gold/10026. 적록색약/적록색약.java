import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	// static
	static int N, normal, starnge;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		init();
//		print();
		run();
		System.out.println(normal + " " + starnge);
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];
			}
		}
	}

	public static void run() {
		
		// 일반인
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					v[i][j] = true;
					normal++;
					normalbfs(i, j);
//					printV();
//					System.out.println();
				}
			}
		}
		// 색약
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					v[i][j] = true;
					starnge++;
					starngebfs(i, j);
//					printV();
//					System.out.println();
				}
			}
		}
	}

	public static void normalbfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) {
					continue;
				}

				if (map[x][y] != map[nx][ny]) {
					continue;
				}

				q.add(new int[] { nx, ny });
				v[nx][ny] = true;
			}
		}
	}

	public static void starngebfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) {
					continue;
				}

				// 파 -> 빨 or 녹
				if (map[x][y] == 'B' && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
					continue;
				}
				// 빨 or 녹 -> 파
				if ((map[x][y] == 'R' || map[x][y] == 'G') && map[nx][ny] == 'B') {
					continue;
				}
				q.add(new int[] { nx, ny });
				v[nx][ny] = true;
			}
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printV() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
