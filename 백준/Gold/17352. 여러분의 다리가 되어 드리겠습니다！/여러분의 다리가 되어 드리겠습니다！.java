import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] parent;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for(int i = 0 ; i <= n ; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (find(i) != find(j)) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			parent[pa] = pb;
		}
	}

	private static int find(int a) {

		if (parent[a] != a) {
			parent[a] = find(parent[a]);
		}

		return parent[a];
	}
}
