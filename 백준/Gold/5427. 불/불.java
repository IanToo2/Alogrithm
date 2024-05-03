import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int r, c;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static Deque<int[]> person;
	static Deque<int[]> fire;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			init();
			run();
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {
		StringTokenizer st;
		person = new ArrayDeque<>();
		fire = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = input[j];
				if (input[j] == '@') {
					person.add(new int[] { i, j, 0 });
				} else if (input[j] == '*') {
					fire.add(new int[] { i, j });
				}
			}
		}
	}

	private static void run() {
		int time = 1;
		int answer = -1;
		while (!person.isEmpty()) {
			if (personMove()) {
				answer = time;
				break;
			}
			fireMove();
			time++;
		}
		if (answer == -1) {
			sb.append("IMPOSSIBLE").append("\n");
		} else {
			sb.append(answer).append("\n");
		}
	}

	private static boolean personMove() {
		// 저장용 Deque
		Deque<int[]> q = new ArrayDeque<>();

		while (!person.isEmpty()) {
			int[] cur = person.poll();
			// 경로 확인용 수정
			if (map[cur[0]][cur[1]] == '*') {
				continue;
			}

			// 이동 경로 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
					person.clear();
					return true;
				}
				// 못가는 위치
				if (map[nx][ny] == '#' || map[nx][ny] == '*' || map[nx][ny] == '@') {
					continue;
				}
				// 주변에 불이 있는지 확인
				if (!checkFire(nx, ny))
					continue;
				map[nx][ny] = '@';
				q.add(new int[] { nx, ny, cur[2] + 1 });
			}
		}
		person = q;
		return false;
	}

	private static boolean checkFire(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			if (map[nx][ny] == '*') {
				return false;
			}
		}
		return true;
	}

	private static void fireMove() {
		Deque<int[]> q = new ArrayDeque<>();
		while (!fire.isEmpty()) {
			int[] cur = fire.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '#' || map[nx][ny] == '*') {
					continue;
				}
				map[nx][ny] = '*';
				q.add(new int[] { nx, ny });
			}
		}
		fire = q;
	}

	private static void printMap() {
		System.out.println();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
