import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// --------------------------------------- //;
	static int N, M, s, e;
	static int min = Integer.MAX_VALUE;
	static ArrayList<LinkedList<int[]>> map = new ArrayList<>();
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
//		print();
//		
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			map.add(new LinkedList<int[]>());
		}
		v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map.get(u).add(new int[] { v, w });
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(map.get(i), ((a, b) -> Integer.compare(a[1], b[1])));
		}

		st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

	}

	public static void run() {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		q.add(new int[] { s, 0 });
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			

			if(v[cur[0]]) continue;
			v[cur[0]] = true;
			if (cur[0] == e) {
				if (cur[1] < min) {
					min = cur[1];
				}
			}

			for (int[] output : map.get(cur[0])) {

				if (cur[1] + output[1] > min || v[output[0]]) {
					continue;
				}

				q.add(new int[] { output[0], cur[1] + output[1] });
			}
		}
		System.out.println(min);
	}

	public static void print() {
		System.out.println();
		for (int i = 1; i <= N; i++) {
			System.out.print(map.get(i));
		}
		System.out.println("s , e = " + s + " " + e);
	}
}