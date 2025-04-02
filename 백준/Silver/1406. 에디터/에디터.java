import java.io.*;
import java.util.*;

// 2초 512mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		LinkedList<Character> list = new LinkedList<>();

		for (char cur : br.readLine().toCharArray()) {
			list.add(cur);
		}

		ListIterator<Character> iter = list.listIterator();

		while (iter.hasNext()) {
			iter.next();
		}

		int order = Integer.parseInt(br.readLine());
		for (int i = 0; i < order; i++) {

			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();

			if ("P".equals(type)) {
				char inputChar = st.nextToken().charAt(0);
				iter.add(inputChar);
			} else if ("L".equals(type) && iter.hasPrevious()) {
				iter.previous();
			} else if ("D".equals(type) && iter.hasNext()) {
				iter.next();
			} else if ("B".equals(type) && iter.hasPrevious()) {
				iter.previous();
				iter.remove();
			}
		}

		for (char cur : list) {
			sb.append(cur);
		}
		
		System.out.println(sb.toString());
	}
}
