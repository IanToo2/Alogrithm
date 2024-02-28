import java.io.*;

import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, R;
	static int map[][];
	static int result[][];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		init();
		logic();
//		print();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void logic() throws Exception {

		int cnt = 0;

		for (int r = 0; r < R; r++) {
			cnt = 0;
			while(cnt < Math.min(N, M) / 2) {
				for (int i = cnt + 1; i < M - cnt; i++) {
					result[cnt][i - 1] = map[cnt][i];
				}
				for (int i = cnt + 1; i < N - cnt; i++) {
					result[i - 1][M - cnt - 1] = map[i][M - cnt - 1];
				}
				for (int i = M - cnt - 2; i >= cnt; i--) {
					result[N - cnt - 1][i + 1] = map[N - cnt - 1][i];
				}
				for (int i = N - cnt - 2; i >= cnt; i--) {
					result[i + 1][cnt] = map[i][cnt];
				}
				cnt++;
			}


			
//			System.out.println();
			map = result;
			result = new int[N][M];

		}
		print();
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}