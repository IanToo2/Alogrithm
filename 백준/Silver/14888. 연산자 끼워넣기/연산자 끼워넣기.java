import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, min, max;
	static int[] data;
	static int[] tool;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		tool = new int[4];

		n = Integer.parseInt(br.readLine());
		data = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			tool[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void run() throws Exception {
		recur(0, 0, 0, 0, 0, data[0]);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void recur(int depth, int a, int b, int c, int d, int sum) {
		if (depth == n-1) {
			if (sum < min) {
				min = sum;
			}
			if (sum > max) {
				max = sum;
			}
			return;
		}
		
		if (a < tool[0]) {
			recur(depth + 1, a + 1, b, c, d, sum + data[depth + 1]);
		}
		if (b < tool[1]) {
			recur(depth + 1, a, b + 1, c, d, sum - data[depth + 1]);
		}
		if (c < tool[2]) {
			recur(depth + 1, a, b, c + 1, d, sum * data[depth + 1]);
		}
		if (d < tool[3]) {
			recur(depth + 1, a, b, c, d + 1, sum / data[depth + 1]);
		}
	}
}
