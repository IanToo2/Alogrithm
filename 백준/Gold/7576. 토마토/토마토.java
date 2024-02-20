import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static int map[][];
	static boolean v[][];
	// 상 하 좌 우
	static int[] dictx = { -1, 1, 0, 0 };
	static int[] dicty = { 0, 0, -1, 1 };
	static int yet = 0;
	static int days = -1;

	static class node {
		int x;
		int y;
		int day;

		node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// input data
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 0) {
					yet++;
				}

			}
		}
		// 익지 않은 토마토가 없는경우
		if (yet == 0) {
			System.out.println(0);
			return;
		}
//		System.out.println("yet : " + yet);
		bfs();
		if(yet != 0) {
			System.out.println(-1);
		}else {
//			System.out.println("yet : " + yet);
			System.out.println(days);
		}
	}

	public static void bfs() {
//			System.out.println("익지 않은 토마토 개수 : " + yet);

		v = new boolean[N][M];
		Queue<node> q = new LinkedList<node>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new node(i, j, 0));
					v[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			
			node cur = q.poll();
			if (cur.day > days) {
				days = cur.day;
			}
			
			for (int i = 0; i < 4; i++) {
				int checkX = cur.x + dictx[i];
				int checkY = cur.y + dicty[i];
				if (0 <= checkX && checkX < N && 0 <= checkY && checkY < M && map[checkX][checkY] == 0 && !v[checkX][checkY]) {

					q.add(new node(checkX, checkY, cur.day + 1));
					v[checkX][checkY] = true;
					yet--;
				}
			}
		}

	}
}