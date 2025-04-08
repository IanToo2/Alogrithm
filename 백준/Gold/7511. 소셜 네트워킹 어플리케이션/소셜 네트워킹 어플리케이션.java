import java.io.*;
import java.util.*;

// 1s, 128mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] parent;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			sb.append("Scenario ").append(i).append(":").append("\n");
			run();
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void run() throws Exception {
		int n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		// set data
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// find result
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append("\n");
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			parent[pa] = pb;
		}
	}

	private static int find(int x) {

		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}
}
