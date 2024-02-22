import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;

	static int map[][];
	static boolean clean[][];

	static int[] backX = { 1, 0, -1, 0 };
	static int[] backY = { 0, -1, 0, 1 };

	static int[] moveX = { -1, 0, 1, 0 };
	static int[] moveY = { 0, 1, 0, -1 };

	static Robot robot;

	public static class Robot {
		int x;
		int y;
		// 0 1 2 3 -> 북 동 남 서
		int d;
		int count = 0;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		init();
		run();
		System.out.println(robot.count);
	}

	public static void init() throws Exception {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		clean = new boolean[N][M];

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		robot = new Robot(x, y, d);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					clean[i][j] = true;
				}
			}
		}
	}

	public static void run() {

		while (true) {

			clean();

			boolean allClean = checkDict();

			// 청소해야하는 칸이 존재하지 않는 경우
			if (!allClean) {
				// 뒤로 움직이기
				if (moveBack()) {
//					System.out.println("뒤로 움직입니다.");
//					System.out.println(robot.x + "," + robot.y);
					continue;
				} else {
					return;
				}
			}
			// 청소해야하는 칸이 존재하는 경우
			else {
				// 반시계 90도 회전
//				System.out.println("회전합니다.");
//				System.out.println("로봇의 좌표 : " + robot.x + " " + robot.y + " " + robot.d);
				robot.d -= 1;
				if (robot.d == -1) {
					robot.d = 3;
				}
			}

			// 바로 앞칸이 청소해야 하는 경우 전진
//			System.out.println(map[robot.x + moveX[robot.d]][robot.y + moveY[robot.d]]);
//			System.out.println(clean[robot.x + moveX[robot.d]][robot.y + moveY[robot.d]]);
//			
			if (map[robot.x + moveX[robot.d]][robot.y + moveY[robot.d]] == 0
					&& !clean[robot.x + moveX[robot.d]][robot.y + moveY[robot.d]]) {
//				System.out.println("전진합니다.");
				robot.x += moveX[robot.d];
				robot.y += moveY[robot.d];
			}
		}
	}

	public static void clean() {
		if (!clean[robot.x][robot.y]) {
			clean[robot.x][robot.y] = true;
			robot.count++;
//			System.out.println("현 위치 청소");
		}
	}

	public static boolean checkDict() {
		for (int i = 0; i < 4; i++) {
			int nextX = robot.x + backX[i];
			int nextY = robot.y + backY[i];

			// 동서남북 확인
			if (0 < nextX && nextX < N - 1 && 0 < nextY && nextY < M - 1) {
				// 하나라도 청소해야 하는 구역이 존재하는 경우
				if (!clean[nextX][nextY]) {
					
//					System.out.println("청소할 구역이 존재합니다." + nextX + " ," + nextY);
					// 검사 탈출
					return true;
				}
			}
		}
		return false;
	}

	public static boolean moveBack() {
		int nextX = robot.x + backX[robot.d];
		int nextY = robot.y + backY[robot.d];
		// 이동 가능한 경우
		if (0 < nextX && nextX < N - 1 && 0 < nextY && nextY < M - 1 && map[nextX][nextY] == 0) {
			robot.x = nextX;
			robot.y = nextY;
			// 1번으로 돌아간다.
			return true;
		}
		return false;
	}
}