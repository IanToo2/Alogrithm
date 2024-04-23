import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, start, answer;
	static int[] data;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		v = new boolean[n];
		start = Integer.parseInt(br.readLine()) - 1;
	}

	private static void run() throws Exception {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			answer++;
			int left = cur - data[cur];
			if (left >= 0 && !v[left]) {
				v[left] = true;
				q.add(left);
			}
			int right = cur + data[cur];
			if (right < n && !v[right]) {
				v[right] = true;
				q.add(right);
			}
		}
		System.out.println(answer);
	}
}
