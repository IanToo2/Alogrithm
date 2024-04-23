import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int k;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			init();
			run();

		}
	}

	private static void init() throws Exception {
		k = Integer.parseInt(br.readLine());
		TreeMap<Long, Integer> map = new TreeMap<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			long value = Long.parseLong(st.nextToken());
			if (order.equals("I")) {
				map.put(value, map.getOrDefault(value, 0) + 1);
			} else {
				if (map.size() == 0)
					continue;
				Long cnt;
				if (value == 1) {
					cnt = map.lastKey();
				} else {
					cnt = map.firstKey();
				}
				if (map.put(cnt, map.get(cnt) - 1) == 1) {
					map.remove(cnt);
				}
			}
		}
		if (map.size() == 0) {
			System.out.println("EMPTY");
		} else {
			System.out.println(map.lastKey() + " " + map.firstKey());
		}

	}

	private static void run() {

	}
}
