import java.io.*;
import java.util.*;

public class Main {
	static int N, M, sr, sc;
	static char map[][];
	static int dr[] = { -1, 0, 1, 0 };// 상 오 하 왼
	static int dc[] = { 0, 1, 0, -1 };
	static char dict[] = { 'U', 'R', 'D', 'L' };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		// 맵 사이즈
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		// 맵 데이터
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		// 시작 좌표
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;

		int result = 0;
		int dir = 0;

		for (int i = 0; i < 4; i++) {
			int cr = sr;
			int cc = sc;
			int cd = i;
			int idx = 1;

			// 순회 시작
			while (true) {
				int nr = cr + dr[cd];
				int nc = cc + dc[cd];
				// 무한 확인
				if (idx > 1000000)
					break;
				// 탈출 or 블랙홀
				if (nr < 0 || nr >= N || nc < 0 | nc >= M || map[nr][nc] == 'C') {
					break;
				}
				// 행성
				if (map[nr][nc] == '/' || map[nr][nc] == '\\') {
					cd = change(map[nr][nc], cd);
				}
				cr = nr;
				cc = nc;
				idx++;
			}
			// 정답 갱신
			if (result < idx) {
				result = idx;
				dir = i;
			}
		}

		// 방향
		System.out.println(dict[dir]);
		// 가장 긴 시간
		// 무한인 경우
		if (result > 1000000) {
			System.out.println("Voyager");
		} else
			System.out.println(result);
	}

	static int change(char c, int d) {
		int nd = 0;
		if (c == '/') {
			if (d == 0) {
				nd = 1;
			} else if (d == 1) {
				nd = 0;
			} else if (d == 2) {
				nd = 3;
			} else if (d == 3) {
				nd = 2;
			}
		} else {
			if (d == 0) {
				nd = 3;
			} else if (d == 1) {
				nd = 2;
			} else if (d == 2) {
				nd = 1;
			} else if (d == 3) {
				nd = 0;
			}
		}
		return nd;
	}
}