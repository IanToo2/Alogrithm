import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static boolean map[][];
	static int[] data;

	public static void main(String[] args) throws Exception {
		int t = 10;
		for (int i = 1; i <= t; i++) {
			init();
			int answer = run();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		int size = Integer.parseInt(br.readLine());
		data = new int[size];
		map = new boolean[255][size];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			int len = Integer.parseInt(st.nextToken());
			data[i] = 255 - len;
			erase(i, len);
		}
	}

	private static int run() {
		int answer = 0;
		for (int i = 2; i < data.length - 2; i++) {
			answer += check(i, data[i]);
		}

		return answer;
	}

	private static int check(int y, int start) {
		//
//		System.out.println(start + " , " + y);
		int cnt = 0;
		for (int i = start; i < 255; i++) {
			if (!map[i][y - 1] && !map[i][y - 2] && !map[i][y + 1] && !map[i][y + 2]) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}

	private static void erase(int idx, int len) {
		// y = idx
		// x = 254 ~ 254 - len;
		for (int i = 254; i > 254 - len; i--) {
			map[i][idx] = true;
		}
	}
}
