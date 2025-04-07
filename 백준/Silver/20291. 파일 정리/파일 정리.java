import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String keep = st.nextToken();
			map.put(keep, map.getOrDefault(keep, 0) + 1);
		}
		for(Map.Entry<String, Integer> cur : map.entrySet()) {
			sb.append(cur.getKey()).append(" ").append(cur.getValue()).append("\n");
		}
		System.out.println(sb);
	}
}
