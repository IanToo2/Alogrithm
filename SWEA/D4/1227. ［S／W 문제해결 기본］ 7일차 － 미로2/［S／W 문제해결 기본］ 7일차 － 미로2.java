import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int answer;
	static int[] s;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		int t = 10;
		for (int i = 1; i <= t; i++) {
			init();
			answer = run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {
		int idx = Integer.parseInt(br.readLine());
		map = new char[100][100];
		v = new boolean[100][100];
		s = new int[2];
		for (int i = 0; i < 100; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 100; j++) {
				map[i][j] = input[j];
				if (map[i][j] == '2') {
					s[0] = i;
					s[1] = j;
				} else if (map[i][j] == '1') {
					v[i][j] = true;
				}
			}

		}
	}

	private static int run() {
		Deque<int[]> q = new ArrayDeque<>();
		v[s[0]][s[1]] = true;
		q.add(new int[] { s[0], s[1] });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == '3') {
				return 1;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || v[nx][ny]) {
					continue;
				}

				v[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}

		}
		return 0;
	}
}
