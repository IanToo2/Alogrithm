import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		// 한라봉, 감귤, 백년초, 키위, 녹차 초콜릿
		int h, t, c, k, g;
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int beforeSize = h + t + c + k + g;
			h -= Integer.parseInt(st.nextToken());
			t -= Integer.parseInt(st.nextToken());
			c -= Integer.parseInt(st.nextToken());
			k -= Integer.parseInt(st.nextToken());
			g -= Integer.parseInt(st.nextToken());
			sb.append(logicOne(h, t, c, k, g, beforeSize)).append("\n");
			logicTwo(h, t, c, k, g);
		}
		System.out.println(sb.toString());

	}

	private static void logicTwo(int h, int t, int c, int k, int g) {
		if (h + t + c + k + g == 0) {
			sb.append("NULL").append("\n");
			return;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('H', h);
		map.put('T', t);
		map.put('C', c);
		map.put('K', k);
		map.put('G', g);

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			int cmp = Integer.compare(b.getValue(), a.getValue());
			if (cmp == 0) {
				return Character.compare(a.getKey(), b.getKey());
			}
			return cmp;
		});
		for (Map.Entry<Character, Integer> cur : list) {
			if (cur.getValue() != 0) {
				sb.append(cur.getKey());
			}
		}
		sb.append("\n");
	}

	private static String logicOne(int h, int t, int c, int k, int g, int beforeSize) {
		int total = h + t + c + k + g;
		if (beforeSize % 10 < 2) {
			return Integer.toString(total) + "7H";
		}
		return Integer.toString(total, beforeSize % 10) + "7H";
	}
}
