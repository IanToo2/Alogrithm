import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, answer;
	static int[] start = new int[3];
	static int[] end = new int[3];

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = Integer.MAX_VALUE;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		v = new boolean[n][n][2];
		List<int[]> s = new ArrayList<>();
		List<int[]> e = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = input[j];
				if (map[i][j] == 'B') {
					s.add(new int[] { i, j });
				} else if (map[i][j] == 'E') {
					e.add(new int[] { i, j });
				}
			}
		}
		start[0] = s.get(1)[0];
		start[1] = s.get(1)[1];
		end[0] = e.get(1)[0];
		end[1] = e.get(1)[1];
		// 시작 방향
		if (s.get(0)[0] == s.get(1)[0]) {
			// 가로
			start[2] = 1;
		} else {
			start[2] = 0;
		}
		// 도착 방향
		if (e.get(0)[0] == e.get(1)[0]) {
			// 가로
			end[2] = 1;
		} else {
			end[2] = 0;
		}
	}

	private static void run() {
		bfs();
		if (answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		System.out.println(answer);
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		v[start[0]][start[1]][start[2]] = true;
		q.add(new int[] { start[0], start[1], start[2], 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) {
				answer = cur[3];
				return;
			}
			// 단순 이동
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				// 중심점이 맵 밖으로 나가는 경우
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny][cur[2]] || map[nx][ny] == '1') {
					continue;
				}
				// 가로인 상태 dict = 1;
				if (cur[2] == 1) {
					if (ny - 1 < 0 || map[nx][ny - 1] == '1') {
						continue;
					}
					if (ny + 1 >= n || map[nx][ny + 1] == '1') {
						continue;
					}

				}
				// 세로인 상태 dict = 0;
				else {
					if (nx - 1 < 0 || map[nx - 1][ny] == '1') {
						continue;
					}
					if (nx + 1 >= n || map[nx + 1][ny] == '1') {
						continue;
					}

				}
				if (map[nx][ny] != '1') {
					v[nx][ny][cur[2]] = true;
					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
				}
			}
			// 회전하기

			if (!v[cur[0]][cur[1]][(cur[2] + 1) % 2]) {
				boolean check = true;
				for (int i = cur[0] - 1; i <= cur[0] + 1; i++) {
					if (!check)
						break;
					for (int j = cur[1] - 1; j <= cur[1] + 1; j++) {
						if (i < 0 || j < 0 || i >= n || j >= n || map[i][j] == '1') {
							check = false;
							break;
						}
					}
				}
				if (check) {
					v[cur[0]][cur[1]][(cur[2] + 1) % 2] = true;
					q.add(new int[] { cur[0], cur[1], (cur[2] + 1) % 2, cur[3] + 1 });
				}
			}

		}

	}
}
