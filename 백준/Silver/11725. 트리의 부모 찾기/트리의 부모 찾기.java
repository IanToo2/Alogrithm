import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static ArrayList<LinkedList<Integer>> map = new ArrayList<>();
	static boolean[] v;
	static int[] parent;

	static class Node {
		int name;
		ArrayList<Integer> link = new ArrayList<>();

		public Node(int name, int nodeName) {
			super();
			this.name = name;
			this.link.add(nodeName);
		}

	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		v = new boolean[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			map.add(new LinkedList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.get(u).add(v);
			map.get(v).add(u);
		}
	}

	public static void run() {
		bfs();
		for (int i = 2; i <= N; i++) {
//			System.out.println(parent[i]);
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int output : map.get(cur)) {
				if (!v[output]) {
					v[output] = true;
					parent[output] = cur;
					q.add(output);
				}

			}
		}
	}

}
