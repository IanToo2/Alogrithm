import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int r, c, q;
	static int[][] map;

	private static void printMap() {
		System.out.println();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		init();
//		printMap();
		run();
		System.out.print(sb);
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} else if (i == 0) {
					map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j - 1];
				} else if (j == 0) {
					map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j];
				} else {
					map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
				}
//				System.out.println(map[i][j]);
			}
		}
	}

	private static void run() throws Exception {
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int[] s = new int[2];
			int[] e = new int[2];
			s[0] = Integer.parseInt(st.nextToken());
			s[1] = Integer.parseInt(st.nextToken());
			e[0] = Integer.parseInt(st.nextToken());
			e[1] = Integer.parseInt(st.nextToken());
			logic(s, e);
		}
	}

	private static void logic(int[] s, int[] e) {
		int answer = map[e[0] - 1][e[1] - 1];
		int cnt = 0;
		for (int i = s[0] - 1; i < e[0]; i++) {
			for (int y = s[1] - 1; y < e[1]; y++) {
				cnt++;
			}
		}
		
//		System.out.println("시작 answer : " + answer);
		
		if (s[0] == 1 && s[1] == 1) {} 
		else if (s[0] == 1) {answer -= map[e[0] - 1][s[1] - 2];} 
		else if (s[1] == 1) {answer -= map[s[0] - 2][e[1] - 1];} 
		else {
//			System.out.println("여기");
//			System.out.println("빼는거 : " + map[s[0] - 2][e[1] - 1] + "," + map[e[0] - 1][s[1] - 2]);
//			System.out.println("더하는거 : " + map[s[0] - 2][s[1] - 2]);
			answer -= (map[s[0] - 2][e[1] - 1] + map[e[0] - 1][s[1] - 2] - map[s[0] - 2][s[1] - 2]);
		}
		
//		System.out.println("종료 answer : " + answer);
		
		
//		System.out.println("cnt = " + cnt);
		sb.append(answer / cnt).append("\n");
	}
}
