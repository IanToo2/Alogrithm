import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, answer;
	static int[] root;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		answer = 0;
		n = Integer.parseInt(br.readLine());
		root = new int[n];
		Arrays.fill(root, -1);
	}

	private static void run() {
		recur(0);
//		System.out.println("n : " + n + " answer : " + answer);
		System.out.println(answer);
	}

	private static void recur(int cnt) {
		if (cnt == n) {
			answer++;
			return;
		}
//		System.out.println(Arrays.toString(root));
		if (cnt == 0) {
			for (int i = 0; i < n; i++) {
				root[0] = i;
				recur(cnt + 1);
			}
		} else {
			// 자리 찾기
			for (int i = 0; i < n; i++) {
				boolean check = true;
				// 이전에 저장된 Queen들의 좌표와 비교하기
				for (int j = 0; j < cnt; j++) {
					// 기울기가 0 or 1 인 경우 = 위치하지 못하는 경우
					int up = cnt - j;
					int down = i - root[j];
					if(down == 0 || Math.abs(up) == Math.abs(down)) {
						check = false;
						break;
					}
				}
				
				if (check) {
					root[cnt] = i;
					recur(cnt + 1);
				}
				
			}
		}
	}
}
