import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();

		for (int i = 1; i <= n; i++) {
			int index = i;
			int value = Integer.parseInt(st.nextToken());
			q.add(new int[] { index, value });
		}

		while (!q.isEmpty()) {
			int[] cur = q.pop();
			sb.append(cur[0]).append(" ");
			if (q.isEmpty()) {
				break;
			}
			int cnt = cur[1];
			if (cnt > 0) {
				cnt--;
			}
			if (cnt < 0) {
				cnt *= -1;
				for (int i = 0; i < cnt; i++) {
					q.addFirst(q.pollLast());
				}
			} else {
				for (int i = 0; i < cnt; i++) {
					q.add(q.pop());
				}
			}

		}
		System.out.println(sb.toString());
	}
}