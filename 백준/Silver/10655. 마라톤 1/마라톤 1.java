import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, sum, max;
	static int[] x, y, len;

	public static void main(String[] args) throws Exception {
		init();
		
		int answer = sum;
		
		for (int i = 1; i < n - 1; i++) {
			int nowAnswer = sum;
			nowAnswer -= (len[i] + len[i+1]);
			nowAnswer += (abs(x[i+1], x[i-1]) + abs(y[i+1], y[i-1]));
			answer = Integer.min(answer, nowAnswer);
			
		}
		System.out.println(answer);
	}

	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine());

		sum = 0;
		max = -1;

		x = new int[n];
		y = new int[n];
		len = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());

			x[i] = nowX;
			y[i] = nowY;

			if (i != 0) {
				len[i] = abs(x[i], x[i - 1]) + abs(y[i], y[i - 1]);
				sum += len[i];
			}
		}
	}

	private static int abs(int a, int b) {
		int result = a - b;

		if (result < 0) {
			result *= -1;
		}

		return result;
	}
}
