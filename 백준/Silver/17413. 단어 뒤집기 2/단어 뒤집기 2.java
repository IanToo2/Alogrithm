import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		String input = br.readLine();
		boolean flag = false;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);

			// flag가 true인 경우
			if (flag && cur != '>') {
				sb.append(input.charAt(i));
				continue;
			}
			
			// flag가 false인 경우
			if (cur == '<') {
				flag = true;
				addData(stack);
				sb.append(cur);
			} else if (cur == '>') {
				flag = false;
				sb.append(cur);
			} else if (cur == ' ') {
				addData(stack);
				sb.append(" ");
			} else {
				stack.add(cur);
			}

		}
		addData(stack);
		System.out.println(sb.toString());
	}

	private static void addData(Stack stack) {
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
	}
}
