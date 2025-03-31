import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		int answer = 1;
		for (int i = 0; i < n; i++) {
			answer *= 2;
		}
		System.out.println(answer);
	}
}
