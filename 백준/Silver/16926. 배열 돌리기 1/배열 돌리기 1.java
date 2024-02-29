import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, R, map[][], keep[][];

	public static void main(String[] args) throws Exception {
		init();
		logic();
		printMap();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		R = Integer.parseInt(st.nextToken());
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void logic() throws Exception {
		keep = new int[N][M];
		int deep = 0;
		if (N < M) {
			deep = N / 2;
		} else {
			deep = M / 2;
		}
		for (int total = 0; total < R; total++) {
			int cnt = 0;
			while (true) {
				if (cnt == deep) {
					break;
				}
				// 맨 위쪽
				for (int i = M - 1 - cnt; i > cnt; i--) {
					keep[cnt][i - 1] = map[cnt][i];
				}
				// 맨 오른쪽
				for (int i = N - 1 - cnt; i > cnt; i--) {
					keep[i - 1][M - 1 - cnt] = map[i][M - 1 - cnt];
				}
				// 맨 아래쪽
				for (int i = cnt; i < M - 1 - cnt; i++) {
					keep[N - 1 - cnt][i + 1] = map[N - 1 - cnt][i];
				}
				// 맨 왼쪽
				for (int i = cnt; i < N - 1 - cnt; i++) {
					keep[i + 1][cnt] = map[i][cnt];
				}
				cnt++;
			}
			map = keep;
			keep = new int[N][M];
//			printMap();
//			System.out.println();
		}

	}

	public static void printMap() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}

	public static void printKeep() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				System.out.print(keep[x][y] + " ");
			}
			System.out.println();
		}
	}
}