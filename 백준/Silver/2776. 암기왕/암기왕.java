import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			run();
		}
		System.out.println(sb);
	}

	private static void run() throws IOException {
		HashSet<Integer> set = new HashSet<>();
		// 수첩 1
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		// 수첩 2
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			if (!set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("0").append("\n");
				continue;
			}

			sb.append("1").append("\n");
		}
	}
}
