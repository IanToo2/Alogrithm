import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input, ".");
			st.nextToken();
			String keep = st.nextToken();
			map.put(keep, map.getOrDefault(keep, 0) + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			return a.getKey().compareTo(b.getKey());
		});

		for (Map.Entry<String, Integer> cur : list) {
			sb.append(cur.getKey()).append(" ").append(cur.getValue()).append("\n");
		}
		System.out.println(sb);
	}
}
