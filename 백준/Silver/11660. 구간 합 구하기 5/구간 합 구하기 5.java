import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		while (M-- != 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int i = x1; i <= x2; i++) {
				answer += (sum[i][y2] - sum[i][y1-1]);
			}
			sb.append(Integer.toString(answer)).append("\n");
//			System.out.println(answer);
		}
		System.out.println(sb.toString());
	}
}