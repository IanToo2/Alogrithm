import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, k, x;
	static Node[] node;
	static int[] v;

	static class Node {
		List<Integer> linked = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		node = new Node[n + 1];
		v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			node[i] = new Node();
			v[i] = Integer.MAX_VALUE;
		}
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			node[u].linked.add(v);
		}
	}

	private static void run() throws Exception {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1] , o2[1]));
		PriorityQueue<Integer> answer = new PriorityQueue<>();
		v[x] = 0;
		q.add(new int[] { x, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (v[cur[0]] < cur[1] || cur[1] > k)
				continue;
			if (cur[1] == k) {
				answer.add(cur[0]);
			}
			v[cur[0]] = cur[1];

			for (int link : node[cur[0]].linked) {
				q.add(new int[] { link, cur[1] + 1 });
			}
		}
		if (answer.size() == 0) {
			System.out.println(-1);
		} else {
//			while (!answer.isEmpty()) {
//				System.out.println(answer.poll());
//			}
			for(int i = 1; i <= n ; i++) {
				if(v[i]==k) {
					System.out.println(i);
				}
			}
		}
//		System.out.println(Arrays.toString(v));
	}
}
