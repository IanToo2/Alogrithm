import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int m, n, answer;

	public static void main(String[] args) throws IOException {
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		answer = n;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int output = Integer.parseInt(st.nextToken());
			n += (input - output);
			if(n < 0 ) {
				answer = 0;
				break;
			}
			answer = Integer.max(n, answer);
		}
		System.out.println(answer);
	}
}
