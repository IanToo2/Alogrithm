import java.io.*;
import java.util.*;

// 2초 256mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int answer = a + b;

		HashSet<Integer> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (set.contains(value)) {
				answer -= 2;
			}
		}

		System.out.println(answer);
	}
}
