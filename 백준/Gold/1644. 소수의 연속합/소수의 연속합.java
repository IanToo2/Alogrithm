import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static long sum;
	static boolean[] decimal;
	static List<Integer> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		sum = 0;
		decimal = new boolean[n + 1];

		for (int i = 2; i <= n; i++) {
			if (decimal[i])
				continue;
			sum += i;
			data.add(i);
			erase(i);
		}
	}

	private static void erase(int cur) {
		for (int i = cur * 2; i <= n; i += cur) {
			if (i % cur == 0) {
				decimal[i] = true;
			}
		}
	}

	private static void run() {
		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = 0;
		while (true) {
			if (sum >= n) {
				sum -= data.get(left++);
			} else if (right == data.size()) {
				break;
			} else {
				sum += data.get(right++);
			}

			if (n == sum) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
