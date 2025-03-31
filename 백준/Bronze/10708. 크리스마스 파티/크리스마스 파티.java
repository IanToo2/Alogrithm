import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, m;
	static int[] target, score;

	public static void main(String[] args) throws Exception {
		init();
		for (int i = 0; i < m; i++) {
			game(i);
		}
		for(int cur : score) {
			System.out.println(cur);
		}
	}

	private static void game(int cnt) throws Exception {
		st = new StringTokenizer(br.readLine());
		int fail = 0;
		int nowTarget = target[cnt] - 1;

		for (int i = 0; i < n; i++) {
			int vote = Integer.parseInt(st.nextToken()) - 1;
			if (vote == nowTarget) {
				score[i]++;
			} else {
				fail++;
			}
		}
		score[nowTarget] += fail;
	}

	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		target = new int[m];
		score = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
	}
}
