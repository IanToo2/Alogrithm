import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] s;
	static boolean[] v = new boolean[2_000_000];

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		s = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
			v[s[i]] = true;
		}

		for (int i = 2; i <= n; i++) {
			recur(0, i, 0, n, 0);
		}

		for (int i = 1; i <= 2_000_000; i++) {
			if(!v[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void recur(int depth, int max, int sum, int size, int start) {
		if (depth == max) {
			if (!v[sum]) {
				v[sum] = true;
			}
			return;
		}

		for (int i = start; i < size; i++) {
			if (s[i] == 0) {
				continue;
			}

			int temp = s[i];
			s[i] = 0;
			recur(depth + 1, max, sum + temp, size, i);
			s[i] = temp;
		}
	}
}
