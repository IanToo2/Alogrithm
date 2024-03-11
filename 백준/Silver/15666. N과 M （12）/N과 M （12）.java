import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// --------------------------------------- //;
	static int N, M;
	static ArrayList<Integer> data = new ArrayList<>();
	static Set<Integer> data2 = new TreeSet<>();
	static int[] answer;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());
		answer = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data2.add(Integer.parseInt(st.nextToken()));
		}
		data = new ArrayList<>(data2);
//		System.out.println(data);
//		System.out.println(data2);
	}

	public static void run() {
		dfs(0, 0);
	}

	public static void dfs(int idx, int depth) {
		if (depth == M) {
//			System.out.println(Arrays.toString(answer));
			for(int output : answer) {
				System.out.print(output + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < data.size(); i++) {
			answer[depth] = data.get(i);
			dfs(i, depth + 1);
		}
	}

	public static void print() {
	}
}