import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int V, E, K;
	static ArrayList<Node> data = new ArrayList<>();
	static int[] answer;

	static class Node {
		int name;
		ArrayList<int[]> next = new ArrayList<>();

		Node(int value) {
			this.name = value;
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		logic();
		for (int i = 1; i < answer.length; i++) {
			if (answer[i] >= Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(answer[i]);
			}
		}
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		// 정점 개수
		V = Integer.parseInt(st.nextToken());
		answer = new int[V + 1];

		data.add(null);
		for (int i = 1; i <= V; i++) {
			data.add(new Node(i));
		}

		// 간선 개수
		E = Integer.parseInt(st.nextToken());

		// 시작 정점
		K = Integer.parseInt(br.readLine());
		// 간선 정보 입력 받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			data.get(u).next.add(new int[] { v, w });
		}
	}

	public static void logic() {
		Node start = data.get(K);
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

		Arrays.fill(answer, Integer.MAX_VALUE);
		answer[start.name] = 0;
		q.add(new int[] { start.name, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (answer[cur[0]] < cur[1])
				continue;

			for (int[] next : data.get(cur[0]).next) {
				if (answer[next[0]] > next[1] + answer[cur[0]]) {
					answer[next[0]] = next[1] + answer[cur[0]];
					q.add(new int[] { next[0], answer[next[0]] });
				}
			}

		}
	}
}