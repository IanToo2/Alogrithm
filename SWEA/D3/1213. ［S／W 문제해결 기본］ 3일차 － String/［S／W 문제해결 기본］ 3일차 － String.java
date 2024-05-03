import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int answer;

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
		char[] check = br.readLine().toCharArray();
		String data = br.readLine();
		answer = 0;
		for (int i = 0; i < data.length() - check.length + 1; i++) {
			// 검사 시작
			if (data.charAt(i) == check[0]) {
				boolean now = true;
				for (int j = 0; j < check.length; j++) {
					if (data.charAt(i + j) != check[j]) {
						now = false;
						break;
					}
				}
				if (now) {
					answer++;
					i += (check.length - 1);
				}
			}
		}

	}

	private static void run() {

	}
}
