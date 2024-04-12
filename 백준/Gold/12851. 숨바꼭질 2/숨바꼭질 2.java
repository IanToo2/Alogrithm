import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, k, answer;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		v = new boolean[400001];

	}

	private static void run() {
		bfs();
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { n, 0 });
		v[n] = true;
		int answer = 0;
		int time = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			v[cur[0]] = true;
			if (cur[0] == k) {
				if (cur[1] < time) {
					time = cur[1];
					answer = 1;
				} else if (cur[1] == time) {
					answer++;
				}
//				System.out.println(cur[1]);
//				return;

				continue;
			}

			if (cur[1] >= time) {
				continue;
			}

			if (cur[0] > k) {
				if (!v[cur[0] - 1])
					q.add(new int[] { cur[0] - 1, cur[1] + 1 });
			} else {
				if (cur[0] - 1 != -1) {
					if (!v[cur[0] - 1])
						q.add(new int[] { cur[0] - 1, cur[1] + 1 });
				}
				if (!v[cur[0] + 1])
					q.add(new int[] { cur[0] + 1, cur[1] + 1 });
				if (!v[cur[0] * 2] && cur[0] * 2 < k * 2 + 1)
					q.add(new int[] { cur[0] * 2, cur[1] + 1 });
			}
		}
		System.out.println(time);
		System.out.println(answer);

	}
}
