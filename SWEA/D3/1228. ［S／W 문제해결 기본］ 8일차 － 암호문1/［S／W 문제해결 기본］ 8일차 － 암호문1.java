import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static List<Integer> original;

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			init();
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		original = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			original.add(Integer.parseInt(st.nextToken()));
		}
		int cnt = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (cnt-- > 0) {
			logic();
		}
		for (int i = 0; i < 10; i++) {
			sb.append(original.get(i)).append(" ");
		}
		sb.append("\n");
	}

	private static void logic() throws Exception {
		String type = st.nextToken();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		List<Integer> addData = new LinkedList<>();
		for (int i = 0; i < y; i++) {
			addData.add(Integer.parseInt(st.nextToken()));
		}
		original.addAll(x, addData);
	}
}
