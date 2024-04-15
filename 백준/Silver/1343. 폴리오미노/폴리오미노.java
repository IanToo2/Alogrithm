import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[] input;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		input = br.readLine().toCharArray();
	}

	private static void run() {
		int cnt = 0;
		for (int i = 0; i < input.length; i++) {
			// X인 경우
			if (input[i] == 'X') {
				cnt++;
				if (cnt == 4) {
					sb.append("AAAA");
					cnt = 0;
				}
			} else if (input[i] == '.') {
				if (cnt == 0) {
					sb.append(".");
				} else if (cnt % 2 != 0) {
					System.out.println(-1);
					return;
				} else {
					sb.append("BB.");
					cnt = 0;
				}
			}

			if (i == input.length - 1) {
				if (cnt == 0) {
					continue;
				}
				if (cnt % 2 != 0) {
					System.out.println(-1);
					return;
				} else {
					if (cnt == 4) {
						sb.append("AAAA");
					} else {
						sb.append("BB");
					}
				}
			}
		}
		System.out.println(sb);
	}
}
