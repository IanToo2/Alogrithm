import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, time;
	static int[][] map;
	static boolean[][] v;
	static int[] feed = new int[3];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Shark s;

	static class Shark {
		int x, y;
		int size = 2;
		int more = 2;

		Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", more=" + more + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		init();
		run();

	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					s = new Shark(i, j);
				}
			}
		}
//		System.out.println(s.toString());
	}

	public static void run() {
		while (true) {
			if (feed[0] == -1 && feed[1] == -1) {
				break;
			}
			feed[0] = -1;
			feed[1] = -1;
			feed[2] = -1;
//			print();

//			System.out.println("now time = " + time);
			bfs();

		}
		System.out.println(time);
	}

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		v = new boolean[n][n];
		// 상어 위치로 시작
		q.add(new int[] { s.x, s.y, 0 });
		v[s.x][s.y] = true;

		// 먹이 탐색
		while (!q.isEmpty()) {

			// 상어 위치 가져오기
			int[] cur = q.poll();
			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				int dict = cur[2] + 1;

				// 좌표값 및 방문 처리 확인
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || v[nx][ny]) {
					continue;
				}
				if(map[nx][ny] > s.size) {
					continue;
				}
				// 처음 먹이를 발견한 경우
				if (feed[0] == -1 && map[nx][ny] < s.size && map[nx][ny] != 0) {
					setFeed(nx, ny, dict);
				}
				// 발견된 먹이가 있는 경우
				else if (feed[2] != -1 && map[nx][ny] < s.size && map[nx][ny] != 0) {
					// 거리가 더 짧은거 먹기
					if (feed[2] > dict) {
						setFeed(nx, ny, dict);
					}
					// 거리가 동일하다면?
					else if (feed[2] == dict) {
						// 더 위에 있는 것 먹기
						if (feed[0] > nx) {
							setFeed(nx, ny, dict);
						}
						// x 좌표도 같다면?
						else if (feed[0] == nx) {
							// y좌표가 더 작은거 먹자
							if (feed[1] > ny) {
								setFeed(nx, ny, dict);
							}
						}
					}
				}
				v[nx][ny] = true;
				q.add(new int[] { nx, ny, dict });
			}
		}

//		System.out.println("-------------------------");

		// 탐색 종료했으면 먹이 먹기
		if (feed[0] != -1) {

			s.more--;
			if (s.more == 0) {
				s.size++;
				s.more = s.size;
			}

			map[s.x][s.y] = 0;
			s.x = feed[0];
			s.y = feed[1];
			time += feed[2];
			map[s.x][s.y] = 9;
		}

	}

	public static void setFeed(int nx, int ny, int dict) {
		feed[0] = nx;
		feed[1] = ny;
		feed[2] = dict;
	}

	public static void print() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");

	}
}
