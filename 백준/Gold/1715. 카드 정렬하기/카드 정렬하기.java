import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int answer = 0;

		if (n == 1) {
			System.out.println(answer);
			return;
		}

		while (q.size()>1) {
			int cur = (q.poll() + q.poll());
			answer += cur;
			q.add(cur);
		}
		
		System.out.println(answer);
	}
}
