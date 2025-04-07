import java.io.*;
import java.util.*;

// 2s 128mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static Map<Long, Long> map = new HashMap<>();
	static Long n, p, q;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());

		System.out.println(getValue(n));
	}

	private static Long getValue(Long n) {
		if (n == 0) {
			return 1L;
		}

		if (map.containsKey(n)) {
			return map.get(n);
		}

		long result = getValue(n / p) + getValue(n / q);
		map.put(n, result);
		return result;
	}
}
