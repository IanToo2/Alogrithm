import java.io.*;
import java.util.*;

// 2초 1536mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, m;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		int answer = 0;
		
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
