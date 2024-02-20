import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int min = Integer.MAX_VALUE;
	static int N, M;
	static boolean v[];
	static int[] visited;
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static ArrayList<int[]> chicken = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		// 치킨집 최대 M개 가능
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int data = Integer.parseInt(st.nextToken());
				if (data == 1) {
					house.add(new int[] { i, j });
				} else if (data == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		M = Math.min(chicken.size(), M);

		v = new boolean[chicken.size()];
		visited = new int[M];
		recur(0,0);
		System.out.println(min);
	}

	public static void recur(int depth, int cur) {

		if (depth == M) {
			int sum = 0;

			for (int j = 0; j < house.size(); j++) {
				int keep = Integer.MAX_VALUE;
				for (int i = 0; i < depth; i++) {
					int dis = Math.min(keep, Math.abs(house.get(j)[0] - chicken.get(visited[i])[0])
							+ Math.abs(house.get(j)[1] - chicken.get(visited[i])[1]));
					keep = Math.min(keep, dis);
				}
				sum += keep;

				if (sum > min) {
					return;
				}
			}

			min = Math.min(min, sum);

			return;
		}

		for (int i = cur; i < chicken.size(); i++) {

			if (!v[i]) {
				v[i] = true;
				visited[depth] = i;
				recur(depth + 1, i+1);
				v[i] = false;
			}
		}
	}
}