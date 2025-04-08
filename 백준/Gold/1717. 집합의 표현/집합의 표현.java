import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch (order) {
			case 0:
				union(a, b);
				break;
			case 1:
				if (find(a) == find(b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	private static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) {
			parent[pa] = pb;
		}
	}
}
