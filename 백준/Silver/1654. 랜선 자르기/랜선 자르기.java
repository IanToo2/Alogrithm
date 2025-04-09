
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int K = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());
		
		int[] data = new int[K];
		long max = 0;

		for (int i = 0; i < K; i++) {
			data[i] = Integer.parseInt(br.readLine());
			if (max < data[i]) {
				max = data[i];
			}
		}
		max += 1;

		long min = 0;
		long mid = 0;
		while (min < max) {
			mid = (max + min) / 2;

			long count = 0;
			for (int i = 0; i < data.length; i++) {
				count += (data[i] / mid);
			}

			if (count < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}