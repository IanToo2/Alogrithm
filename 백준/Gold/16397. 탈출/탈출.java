import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	// ------------------------------------------------------- //
	static int N, T, G;
	static int answer = -1;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		v = new boolean[100000];
	}

	public static void run() {
		bfs();
//		buttonB(N);
		if (answer != -1) {
			System.out.println(answer);
		} else {
			System.out.println("ANG");
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		
		while (!q.isEmpty()) {
			int cur[] = q.poll();
//			System.out.println("value,cnt = " + cur[0] + " " + cur[1]);
			// 방문했던 경우
			if (v[cur[0]]) {
				continue;
			}
			v[cur[0]] = true;
			// 종료 조건
			// 버튼을 누를 수 있는 최대 횟수 초과
			if (cur[1] > T) {
				continue;
			}
			// 목표지점 도착
			if (cur[0] == G) {
				answer = cur[1];
				return;
			}
			// 로직
			// 버튼 A
			if (cur[0] + 1 < 100000) {
				q.add(new int[] { (cur[0] + 1), cur[1] + 1 });
			}
			// 버튼 B
			if (cur[0] * 2 < 100000) {
				cur[0] = buttonB(cur[0]);
				q.add(new int[] { cur[0], cur[1] + 1 });
			}
		}
	}

	public static int buttonB(int cur) {
		cur *= 2;
		sb = new StringBuilder();
		String strData = Integer.toString(cur);
		char[] charData = strData.toCharArray();
		for (int i = 0; i < charData.length; i++) {
			if (charData[i] != '0') {
				int result = (int) charData[i] - 1;
				charData[i] = (char) result;
				break;
			}
		}
		for (char output : charData) {
			sb.append(output);
		}
		cur = Integer.parseInt(sb.toString());
//		sb.
		return cur;
	}
}