import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];

		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			max = Integer.max(max, data[i]);
		}

		int total = Integer.parseInt(br.readLine());

		int s = 1;
		int e = max;
		int result = 0;

		while (s <= e) {
			int mid = (s + e) / 2;

			int sum = 0;
			for (int cur : data) {
				if (cur > mid) {
					sum += mid;
					continue;
				}
				sum += cur;
			}

			if (sum <= total) {
				result = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
