import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		int n, k;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> q = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}

		while (k-- > 0) {
			Long a = q.poll();
			Long b = q.poll();
			q.add(a + b);
			q.add(a + b);
		}

		Long answer = 0L;
		while (!q.isEmpty()) {
			answer += q.poll();
		}
		System.out.println(answer);

	}

	private static void run() throws Exception {

	}
}
