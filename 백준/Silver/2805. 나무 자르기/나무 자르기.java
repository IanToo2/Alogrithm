import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] tree = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Integer.max(max, tree[i]);
		}
		Arrays.sort(tree);

		int start = 0;
		int end = max;
		int result = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (tree[i] > mid) {
					sum += (tree[i] - mid);
				}
			}

			if (sum >= m) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
