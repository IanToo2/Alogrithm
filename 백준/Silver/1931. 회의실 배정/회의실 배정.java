import java.io.*;
import java.util.*;

import org.xml.sax.helpers.AttributeListImpl;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		ArrayList<int[]> data = new ArrayList<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			data.add(new int[] { start, end });

		}

		Collections.sort(data, (a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});

		int end = 0;
		int cnt = 0;
		for (int[] output : data) {
			if (output[0] >= end) {
				cnt++;
				end = output[1];
			}
		}
		System.out.println(cnt);
	}
}