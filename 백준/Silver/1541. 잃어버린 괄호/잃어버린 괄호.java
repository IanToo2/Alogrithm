import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static Queue<Integer> num = new LinkedList<>();
	static Queue<Character> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		char[] input = br.readLine().toCharArray();
		String keep = "";
		for (char output : input) {
			if (output == '+' || output == '-') {
				if (keep != "") {
					num.add(Integer.parseInt(keep));
					keep = "";
				}
				q.add(output);

			} else {
				keep += output;
			}
		}
		if (keep != "") {
			num.add(Integer.parseInt(keep));
		}

		run();
	}

	public static void run() {
		int start = num.poll();
		int keep = 0;

		while (!q.isEmpty()) {
			char now = q.poll();

			if (now == '+') {
				if (keep == 0) {
					start += num.poll();
				} else {
					keep += num.poll();
				}
			}

			else if (now == '-') {
				if (keep != 0) {
					start -= keep;
					keep = 0;
				}
				keep += num.poll();
			}

		}
		start -= keep;

		System.out.println(start);
	}
}