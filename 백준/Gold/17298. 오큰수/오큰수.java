import java.io.*;
import java.util.*;

// 1초 512mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());

		int[] data = new int[n];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[i] = -1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			/*
			 * System.out.println("stack : " + stack.toString());
			 * System.out.println("answer : " + Arrays.toString(answer));
			 */
			int value = Integer.parseInt(st.nextToken());
			data[i] = value;

			if (stack.isEmpty()) {
				stack.add(i);
				continue;
			}

			while (true) {
				if (stack.isEmpty() || data[stack.peek()] >= value) {
					stack.add(i);
					break;
				}

				int index = stack.pop();
				answer[index] = value;
			}
		}
		
		/* System.out.println(Arrays.toString(answer)); */
		for(int cur : answer) {
			sb.append(cur).append(" ");
		}
		System.out.println(sb.toString());
	}
}
