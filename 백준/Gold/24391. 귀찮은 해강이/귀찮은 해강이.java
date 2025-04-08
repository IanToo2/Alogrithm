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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		st = new StringTokenizer(br.readLine());
		int answer = 0;
		if (n == 1) {
			System.out.println(answer);
			return;
		}

		int start = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n - 1; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(find(start) != find(next)) {
				answer++;
			}
			start = next;
		}
		
		System.out.println(answer);
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
