import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static ArrayList<Integer> order = new ArrayList<>();
	static Deque<Integer> result = new ArrayDeque<>();
	static Deque<Integer> start = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		init();
		logic();
		print();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			order.add(Integer.parseInt(st.nextToken()));
			result.addLast(i + 1);
		}
		Collections.reverse(order);
	}

	public static void logic() throws Exception {
		for (int order : order) {
			if (order == 1) {
				start.addFirst(result.pollFirst());
			} else if (order == 2) {
				int keep = start.pollFirst();
				start.addFirst(result.pollFirst());
				start.addFirst(keep);
			} else {
				start.addLast(result.pollFirst());
			}
		}
	}

	public static void print() {
//		System.out.println((order));
		while (!start.isEmpty()) {
			sb.append(start.poll()).append(" ");

		}
		System.out.println(sb);
	}
}