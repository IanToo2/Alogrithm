import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		HashSet<Long> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(Long.parseLong(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int before = set.size();
			Long data = Long.parseLong(st.nextToken());
			set.add(data);
			int after = set.size();
			if (before == after) {
				sb.append("1");
			} else {
				set.remove(data);
				sb.append("0");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
