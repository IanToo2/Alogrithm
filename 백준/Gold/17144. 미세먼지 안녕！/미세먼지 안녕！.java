import java.io.*;
import java.util.*;

import javax.sound.midi.Synthesizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int r, c, t;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] board;
	static int[][] boardKeep;
	static boolean[][] v;

	static List<int[]> air = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		board = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					air.add(new int[] { i, j });
				}
			}
		}
	}

	public static void run() {
		for (int i = 0; i < t; i++) {
			// 1. 미세먼지 확산
			diff();
//			System.out.println("먼지 확산 후");
//			printMap();
			// 2. 공기청정기 작동
			wind();
//			System.out.println("공기 청정기 가동 후");
//			printMap();
//			System.out.println();
		}
		System.out.println(totalCnt());
	}

	public static void diff() {
		boardKeep = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] > 4) {
					dict(i, j);
				} else {
					boardKeep[i][j] += board[i][j];
				}
			}
		}

		board = boardKeep;

//		printMap();
	}

	public static void dict(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c || board[nx][ny] == -1)
				continue;

			cnt++;
			boardKeep[nx][ny] += (board[x][y] / 5);

		}
		boardKeep[x][y] += (board[x][y] - ((board[x][y] / 5) * cnt));
	}

	public static void wind() {
		up();
		down();
	}

	public static void up() {
		int[] cur = air.get(0);
		// 1. 상 -> 하
		for (int i = cur[0] - 1; i > 0; i--) {
			board[i][0] = board[i - 1][0];
		}
		// 2. 우 -> 좌
		for (int i = 0; i < c - 1; i++) {
			board[0][i] = board[0][i + 1];
		}
		// 3. 하 -> 상
		for (int i = 0; i < cur[0]; i++) {
			board[i][c - 1] = board[i + 1][c - 1];
		}
		// 4. 좌 -> 우
		for (int i = c - 1; i > 1; i--) {
//			System.out.println("i : " + i);
			board[cur[0]][i] = board[cur[0]][i - 1];
		}
		board[cur[0]][cur[1] + 1] = 0;
	}

	public static void down() {
		int[] cur = air.get(1);
		// 1. 하 -> 상
		for (int i = cur[0] + 1; i < r - 1; i++) {
			board[i][0] = board[i + 1][0];
		}
		// 2. 우 -> 좌
		for (int i = 0; i < c - 1; i++) {
			board[r - 1][i] = board[r - 1][i + 1];
		}
		// 3. 상 -> 하
		for (int i = r - 1; i > cur[0]; i--) {

			board[i][c - 1] = board[i - 1][c - 1];
		}
		// 4. 좌 -> 우
		for (int i = c - 1; i > cur[1] + 1; i--)
			board[cur[0]][i] = board[cur[0]][i - 1];
		board[cur[0]][cur[1] + 1] = 0;
	}
	public static int totalCnt() {
		int sum = 0;
		for(int i = 0 ; i < r; i++) {
			for(int j = 0;j<c;j++) {
				if(board[i][j] > 0) {
					sum+=board[i][j];
				}
			}
		}
		return sum;
	}

	public static void printMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
