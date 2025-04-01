import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[10_000_001];
		int[] m = new int[10_000_001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value >= 0) {
				p[value]++;
			} else {
				value *= -1;
				m[value]++;
			}
		}

		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value >= 0) {
				sb.append(p[value]);
			} else {
				value *= -1;
				sb.append(m[value]);
			}
			sb.append(" ");
		}

		System.out.println(sb.toString());
	}
}
