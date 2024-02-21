import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int map[][];
	static boolean v[];
	static int cycle = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			map[u][v] = 1;
			map[v][u] = 1;
		}


		for (int i = 1; i <= N; i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && !v[j]) {
					v[j] = true;

					q.add(j);
				}
			}
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int k = 1; k <= N; k++) {

					if (map[cur][k] == 1 && !v[k]) {
						v[k] = true;
						q.add(k);
					}

				}
			}
			cycle++;
		}
		System.out.println(cycle);
	}

	public static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}