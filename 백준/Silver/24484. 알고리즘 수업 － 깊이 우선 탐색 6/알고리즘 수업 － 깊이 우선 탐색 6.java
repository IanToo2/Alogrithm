import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, r;
	static Long cnt;
	static long[] level;
	static long[] root;
	static boolean[] v;
	static Node[] node;

	static class Node {
		Set<Integer> linked = new TreeSet<>(Collections.reverseOrder());
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		node = new Node[100001];
		for (int i = 1; i <= n; i++) {
			node[i] = new Node();
		}
		v = new boolean[100001];
		root = new long[100001];
		level = new long[100001];
		Arrays.fill(level, -1);
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			node[u].linked.add(v);
			node[v].linked.add(u);
		}
	}

	private static void run() throws Exception {
		cnt = (long) 1;
		dfs(r, 0);
		long answer = 0;
//		System.out.println(Arrays.toString(root));
//		System.out.println(Arrays.toString(level));
		for (int i = 1; i <= n; i++) {
			long value = root[i] * level[i];
			answer += value;
		}
		System.out.println(answer);
	}

	private static void dfs(int cur, int dept) {
		v[cur] = true;
		root[cur] = cnt;
		level[cur] = dept;

		for (int link : node[cur].linked) {
			if (v[link])
				continue;
			cnt++;
			dfs(link, dept + 1);

		}
	}
}
