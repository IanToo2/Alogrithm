import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int answer = 0;

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if ("ENTER".equals(input)) {
				answer += set.size();
				set = new HashSet<>();
				continue;
			}

			set.add(input);
		}
		answer += set.size();
		System.out.println(answer);
	}
}
