import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		boolean[] v = new boolean[246913];
		Arrays.fill(v, true);
		v[0] = v[1] = false;

		for (int i = 2; i * i <= 246913; i++) {
			if (v[i]) {
				for (int j = i * i; j <= 246913; j += i) {
					v[j] = false;
				}
			}
		}
		while (true) {
			int cur = Integer.parseInt(br.readLine());
			if (cur == 0) {
				return;
			}

			int answer = 0;
			for (int i = cur + 1; i <= 2 * cur; i++) {
				if (v[i])
					answer++;
			}
			System.out.println(answer);
		}
	}
}
