import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.length() < m) {
				continue;
			}

			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 1);
			}
		}

		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			int cmp = Integer.compare(b.getValue(), a.getValue());
			if (cmp == 0) {
				int lenCmp = Integer.compare(b.getKey().length(), a.getKey().length());

				if (lenCmp == 0) {
					return a.getKey().compareTo(b.getKey());
				}

				return lenCmp;

			}
			return cmp;
		});

		for (Map.Entry<String, Integer> cur : list) {
			sb.append(cur.getKey()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
