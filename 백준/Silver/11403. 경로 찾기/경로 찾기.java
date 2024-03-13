import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// ------------------------------------------------------- //
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		init();
		run();
		print();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					map[i][j] = input;

				} else {
					map[i][j] = Integer.MAX_VALUE / 2;
				}
			}
		}
	}

	public static void run() {
		for (int k = 0; k < N; k++) {
			// 노드 i에서 j로 가는 경우.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}

	public static void bfs() {

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != Integer.MAX_VALUE / 2) {
					System.out.print(1 + " ");
				}else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

}