import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static Node[] nodes;
	static Deque<int[]> q = new ArrayDeque<>();

	static class Node {
		boolean check;
		int time = -1;
		int cnt;
		List<Integer> link = new ArrayList<>();

		@Override
		public String toString() {
			return "Node [check=" + check + ", time=" + time + ", cnt=" + cnt + ", link=" + link + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		init();
		run();
//		printNode();
		printAnswer();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		nodes = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 0) {
					break;
				}
				nodes[i].link.add(value);
			}
		}

		// 처음 유포자
//		System.out.println("최초 유포자");
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int value = Integer.parseInt(st.nextToken());
//			System.out.println(value);
			nodes[value].check = true;
			q.add(new int[] { value, 0 });

		}

	}

	private static void run() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int nowNum = cur[0];
			int nowTime = cur[1];
//			System.out.println("now Num, Time : " + nowNum + ":" + nowTime);

			nodes[nowNum].time = nowTime;

			for (int linked : nodes[nowNum].link) {
				if (nodes[linked].check)
					continue;

				nodes[linked].cnt++;
				int size = nodes[linked].link.size();
				if (size % 2 == 0) {
					if (size / 2 <= nodes[linked].cnt) {
						nodes[linked].check=true;
						q.add(new int[] { linked, nowTime + 1 });
					}
				} else {
					if (size / 2 + 1 <= nodes[linked].cnt) {
						nodes[linked].check=true;
						q.add(new int[] { linked, nowTime + 1 });
					}
				}
			}

		}
	}

	private static void printNode() {
		for (Node output : nodes) {
			if (output == null) {
				continue;
			}
			System.out.println(output.toString());
		}
	}

	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for (Node output : nodes) {
			if (output == null)
				continue;

			sb.append(output.time + " ");
		}
		System.out.print(sb);
	}
}
