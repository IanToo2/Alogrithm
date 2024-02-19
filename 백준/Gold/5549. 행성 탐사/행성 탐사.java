import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		int[][][] map = new int[M + 2][N + 2][3];

		for (int i = 1; i <= M; i++) {

			char[] input = br.readLine().toCharArray();

			for (int j = 1; j <= N; j++) {

				int target = -1;
				if (input[j - 1] == 'J') {
					target = 0;
				} else if (input[j - 1] == 'O') {
					target = 1;
				} else {
					target = 2;
				}
				for (int k = 0; k < 3; k++) {
					map[i][j][k] = map[i - 1][j][k] + map[i][j - 1][k] - map[i - 1][j - 1][k];
				}
				map[i][j][target] += 1;
			}
		}
		// 로직
		sb = new StringBuilder();

		while (K-- > 0) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 3; i++) {
				int result = map[c][d][i] - map[a - 1][d][i] - map[c][b - 1][i] + map[a - 1][b - 1][i];
				if (i == 2) {
					sb.append(result);
				} else {
					sb.append(result).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
