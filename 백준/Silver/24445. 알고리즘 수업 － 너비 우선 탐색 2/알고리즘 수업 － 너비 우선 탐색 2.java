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
	static int cnt = 1;
	static List<ArrayList<Integer>> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		bfs();
		print();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			data.add(new ArrayList<>());
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
		for(int i = 1; i <= N ; i++) {
			Collections.sort(data.get(i), Collections.reverseOrder());
		}
		
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		v[R] = true;
		answer[R] = cnt;
		cnt++;
		while (!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println("cur : " + cur);
			for (int output : data.get(cur)) {
//				System.out.println(output);
				if (!v[output]) {
					v[output] = true;
					answer[output] = cnt;
					cnt++;
					q.add(output);
				}
			}
		}

	}

	public static void print() {

		for(int i = 1; i <= N;i++) {
			System.out.println(answer[i]);
		}
	}

}