import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// ------------------------------------------------------- //
	// 사람 수, 파티 수
	static int N, M, R;
	static boolean[] v;
	static int[] answer;
	static List<TreeSet<Integer>> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		bfs();
		print();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			data.add(new TreeSet<>());
		}
		v = new boolean[N + 1];
		answer = new int[N + 1];
		
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			data.get(u).add(v);
			data.get(v).add(u);
		}

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { R, 1 });
		v[R] = true;
		answer[R] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int output : data.get(cur[0])) {
				if (!v[output]) {
					v[output] = true;
					answer[output] = cur[1];
					q.add(new int[] { output, cur[1] + 1 });
				}
			}
		}

	}

	public static void print() {

		for (int i = 1; i <= N; i++) {
			if (i != R && answer[i] == 0) {
				System.out.println(-1);
			} else {
				System.out.println(answer[i]);
			}
		}
	}

}