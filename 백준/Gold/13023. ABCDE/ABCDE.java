import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m;
	static boolean answer;
	static boolean[] v;
	static List<Integer>[] person;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		person = new List[n + 1];
		v = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			person[i] = new ArrayList<>();
		}
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			person[u].add(v);
			person[v].add(u);
		}
	}

	private static void run() {
		for (int i = 0; i < n; i++) {
			if (answer) {
				System.out.println("1");
				break;
			}
			v = new boolean[n];
			v[i] = true;
			dfs(i, 1);
			
		}
		if (!answer) {
			System.out.println("0");
		}
	}

	private static void dfs(int now, int depth) {
		if (answer) {
			return;
		}
		if (depth >= 5) {
			answer = true;
			return;
		}
		
		for(int output : person[now]) {
			if(v[output]) continue;
			
			v[output] = true;
			dfs(output, depth + 1);
			v[output] = false;
		}
	}
}
