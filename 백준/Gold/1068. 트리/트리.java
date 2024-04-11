import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, deleteNode, start;
	static boolean[] v;
	static Node[] nodes;

	static class Node {
		int value;
		int parent;
		List<Integer> linked = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		v = new boolean[n];
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == -1) {
				start = i;
				nodes[i].parent = value;
			} else {
				nodes[i].parent = value;
				nodes[value].linked.add(i);
			}

		}
		deleteNode = Integer.parseInt(br.readLine());
		v[deleteNode] = true;
	}

	private static void run() {
		if(deleteNode != start) {
			printNode();
		}else {
			System.out.println(0);
		}
	}

	private static void printNode() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur);
			int size = 0;
			if(nodes[cur].linked.contains(deleteNode)) {
				size = nodes[cur].linked.size() - 1;
			}else {
				size = nodes[cur].linked.size();
			}
			if(size== 0) {
				cnt++;
//				System.out.println("leaf node");
			}
			for (int num : nodes[cur].linked) {
				if (v[num])
					continue;
				q.add(num);
			}
		}
		System.out.println(cnt);
	}
}
