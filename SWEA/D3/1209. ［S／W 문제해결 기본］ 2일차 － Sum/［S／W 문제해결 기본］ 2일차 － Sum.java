import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int answer;
	static int map[][];

	public static void main(String[] args) throws Exception {
		int t = 10;
		for (int i = 1; i <= t; i++) {
			init();
			run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {
		int idx = Integer.parseInt(br.readLine());
		map = new int[100][100];
		for (int i = 0; i < 100; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 100; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void run() {
		List<Integer> sumData = new ArrayList<>();
		answer = 0;
		// 가로
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += map[i][j];
			}
			sumData.add(sum);
		}
		// 세로
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += map[j][i];
			}
			sumData.add(sum);
		}
		// 대각선
		// 1. 우측 아래로
		int x = 0;
		int y = 0;
		int sum = 0;
		while (true) {
			if (x == 100 && y == 100) {
				break;
			}
			sum += map[x][y];
			x++;
			y++;
		}
		sumData.add(sum);

		// 2. 좌측 아래로
		x = 0;
		y = 99;
		sum = 0;
		while (true) {
			if (x == 100 && y == -1) {
				break;
			}
			sum += map[x][y];
			x++;
			y--;
		}
		sumData.add(sum);

		Collections.sort(sumData);
//		System.out.println(sumData.get(sumData.size() - 1));
		answer = sumData.get(sumData.size() - 1);
	}
}
