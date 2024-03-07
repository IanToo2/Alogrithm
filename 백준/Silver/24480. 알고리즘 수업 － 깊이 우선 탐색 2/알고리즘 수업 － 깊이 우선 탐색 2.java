import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// --------------------------------------- //
	static int N, M, start, cnt;
	static boolean[] v;
	static int[] answer;
	static ArrayList<LinkedList<Integer>> map = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
//		print();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		v = new boolean[N + 1];
		answer = new int[N + 1];

		M = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(st.nextToken());
		answer[start] = 1;
		cnt = 2;
		v[start] = true;

		for (int i = 0; i <= N; i++) {
			map.add(new LinkedList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		for(int i = 1 ; i <= N ; i ++) {
			Collections.sort(map.get(i), Comparator.reverseOrder());
		}
	}

	public static void run() {
		dfs(start);
//		System.out.println(Arrays.toString(answer));
		for(int i = 1; i <= N ; i++) {
			System.out.println(answer[i]);
		}
	}

	public static void dfs(int cur) {
		for (int output : map.get(cur)) {
			if (v[output]) {
				continue;
			}
//			System.out.println(output);
			v[output] = true;
			answer[output] = cnt;
			cnt++;
			dfs(output);
		}
	}

	public static void print() {
		for (LinkedList<Integer> output : map) {
			System.out.println(output);
		}
	}
}