import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;

	public static void main(String[] args) throws Exception {

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				System.out.println(sb.toString());
				return;
			}
			
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				answer += i * i;
			}
			
			sb.append(answer).append("\n");
		}
	}
}
