import java.io.*;
import java.util.*;

// 1초 256mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			sb = new StringBuilder();
			run();
			System.out.println(sb.toString());
		}
	}

	private static void run() throws IOException {
		char[] input = br.readLine().toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator();

		for (int i = 0; i < input.length; i++) {
			char cur = input[i];
			
			switch (cur) {
			case '<':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case '>':
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case '-':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			default:
				iter.add(cur);
			}
		}
		for (char cur : list) {
			sb.append(cur);
		}
	}
}
