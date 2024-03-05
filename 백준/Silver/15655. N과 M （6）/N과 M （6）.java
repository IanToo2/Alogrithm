import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] result;
	static boolean[] v;
	static ArrayList<Integer> data = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		v = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data.add(Integer.parseInt(st.nextToken()));
		}
		data.sort(null);
	}

	public static void run() {
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int idx, int depth) {
		if (depth == M) {
			for(int output : result) {
				sb.append(output).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				result[depth] = data.get(i);
				dfs(i, depth + 1);
				v[i] = false;
			}
		}
	}

}
