import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		init();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int answerA = b - a;
		int answerB = b;
		int GCD = GCD(answerA, answerB);

		System.out.println(answerA / GCD + " " + answerB / GCD);
	}

	private static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}
}
