import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, min, max;
	static int[] check;
	static int[] num;
	static int[] oper;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			run();
			sb.append("#").append(i).append(" ").append(max - min).append("\n");
		}
		System.out.print(sb);
	}

	public static void init() throws Exception {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		n = Integer.parseInt(br.readLine());

		// 사칙 연산 기호
		// + - * /
		st = new StringTokenizer(br.readLine());
		oper = new int[4];
		check = new int[4];

		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		// 수식 사용 기호
		st = new StringTokenizer(br.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void run() {
		recur(num[0], 1);
	}

	public static void recur(int sum, int depth) {
		if (depth == n) {
//			System.out.println(sum);
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (check[i] < oper[i]) {
				check[i]++;
				recur(operation(sum, i, depth), depth + 1);
				check[i]--;

			}
		}

	}

	public static int operation(int sum, int i, int idx) {
		if (i == 0) {
			sum += num[idx];
		} else if (i == 1) {
			sum -= num[idx];
		} else if (i == 2) {
			sum *= num[idx];
		} else if (i == 3) {
			sum /= num[idx];
		}
		return sum;
	}
}
