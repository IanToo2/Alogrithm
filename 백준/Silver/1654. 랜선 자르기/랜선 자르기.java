import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] data = new int[k];
		
		int max = 0;
		for (int i = 0; i < k; i++) {
			data[i] = Integer.parseInt(br.readLine());
			max = Integer.max(max, data[i]);
		}
		
		long start = 1;
		long end = max;
		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long now = 0;

			for (int cur : data) {
				now += cur / mid;
			}

			if (now >= n) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;

			}
		}

		System.out.println(result);
	}
}
