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
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 0);
			}
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			int cmp = b.getValue().compareTo(a.getValue());
			if (cmp == 0) {
				return a.getKey().compareTo(b.getKey());
			}
			return cmp;
		});

		System.out.println(list.get(0).getKey().toString());
	}
}
