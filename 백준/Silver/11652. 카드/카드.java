import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		HashMap<Long, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			Long value = Long.parseLong(br.readLine());
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}
		List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			int cmp = Integer.compare(b.getValue(), a.getValue());
			if (cmp == 0) {
				return Long.compare(a.getKey(), b.getKey());
			}

			return cmp;
		});

		System.out.println(list.get(0).getKey());
	}
}
