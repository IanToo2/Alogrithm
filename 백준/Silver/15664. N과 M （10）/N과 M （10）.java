import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] result;
	static boolean[] v;
	static ArrayList<Integer> data = new ArrayList<>();
	static LinkedHashSet<String> answer = new LinkedHashSet<>();

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
		dfs(0);
		for (String output : answer) {
			System.out.println(output);
		}
	}

	public static void dfs(int depth) {
		if (depth == M) {

			StringBuilder sb = new StringBuilder();
			for (int p : result)
				sb.append(p).append(' ');
			answer.add(sb.toString());
			return;

		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				if (depth == 0) {
					result[depth] = data.get(i);
					dfs(depth + 1);
				} else if (data.get(i) >= result[depth - 1]) {
					result[depth] = data.get(i);
					dfs(depth + 1);
				}
				v[i] = false;
			}
		}
	}

}
