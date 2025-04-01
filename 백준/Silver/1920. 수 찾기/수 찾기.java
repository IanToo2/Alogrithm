import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static List<Long> list;

	public static void main(String[] args) throws Exception {
		init();
		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < t; i++) {
			long target = Long.parseLong(st.nextToken());

			int mid;
			int low = 0;
			int high = n - 1;
			boolean flag = false;
			while (low <= high) {

				mid = (low + high) / 2;

				if (list.get(mid) == target) {
					flag = true;
					sb.append("1").append("\n");
					break;
				} else if (target < list.get(mid)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (!flag) {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<Long>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(list);
	}
}
