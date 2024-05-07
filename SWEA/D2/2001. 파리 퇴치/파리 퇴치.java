import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int size, answer;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		size = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
			}
		}
//		print();
	}

	private static void run() {
		answer = 0;
		int mapSize = map[0].length;
		for (int i = size; i < mapSize; i++) {
			for (int j = size; j < mapSize; j++) {
				answer = Math.max(answer, map[i][j] - map[i-size][j] - map[i][j-size] + map[i-size][j-size] );
			}
		}
//		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
