import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		init();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int cur = pq.poll();
		long answer = 0;
		while (!pq.isEmpty()) {
			answer += (cur + pq.poll());
		}
		System.out.println(answer);
	}
}
