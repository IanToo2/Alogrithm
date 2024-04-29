import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static Set<Integer> set = new LinkedHashSet<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreElements()) {
			set.add(Integer.parseInt(st.nextToken()));
		}
	}

	private static void run() {
		for(int output : set) {
//			System.out.print(output + " ");
			sb.append(output).append(" ");
		}
		System.out.println(sb);
	}
}
