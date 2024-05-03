import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int answer;
	static int[] data;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() throws Exception {
		int idx = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		data = new int[101];

		for (int i = 0; i < 1000; i++) {
			int score = Integer.parseInt(st.nextToken());
			data[score]++;
		}
		idx = 0;
		int cnt = 0;
		for (int i = 0; i <= 100; i++) {
			if (data[i] > cnt) {
				idx = i;
				cnt = data[i];
			} else if (data[i] == cnt) {
				idx = Math.max(i, idx);
				cnt = data[idx];
			}
		}
//		System.out.println(idx + " : " + cnt);
		answer = idx;
	}

}
