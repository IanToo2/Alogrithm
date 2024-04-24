import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m, answer;
	static boolean[] v;
	static int[] root;
	static Node[] node;

	static class Node {
		PriorityQueue<int[]> linked = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		node = new Node[n + 1];
		root = new int[n+1];
		Arrays.fill(root, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			node[i] = new Node();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[u].linked.add(new int[] { v, w });
			node[v].linked.add(new int[] { u, w });
		}
	}

	private static void run() throws Exception {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		q.add(new int[] { 1, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if(root[cur[0]] > cur[1]) {
				root[cur[0]] = cur[1];
			}else {
				continue;
			}

			for (int[] output : node[cur[0]].linked) {
				q.add(new int [] {output[0], output[1] + cur[1]});

			}
		}
		System.out.println(root[n]);
	}
}
