import java.io.*;
import java.util.*;

public class Main {
	static int r, c, time, cnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static int[][] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
//		printMap();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		time = 1;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		v = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = input[j];
			}
		}

	}

	private static void run() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (v[i][j] == 0) {
					bfs(i, j);
				}

			}
		}
//		System.out.println(cnt + " , " + time);
		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		v[x][y] = time;
		
		int order = checkOrder(map[x][y]);
		int nx = x + dx[order];
		int ny = y + dy[order];
//		System.out.println("x,y : " + x + ","+y + " v data : " + v[nx][ny] + " time : " + time);
		if (v[nx][ny] == 0) {
			bfs(nx, ny);
		} else {
			if (v[nx][ny] == time) {
//				System.out.println("cnt ++ ");
				cnt++;
			}
			time++;
		}

	}

	private static int checkOrder(char order) {
		if (order == 'U') {
			return 0;
		} else if (order == 'D') {
			return 1;
		} else if (order == 'L') {
			return 2;
		} else {
			return 3;
		}
	}

	private static void printMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
