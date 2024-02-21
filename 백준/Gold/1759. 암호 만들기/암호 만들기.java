import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char data[];
	static boolean[] v;
	static int L, C;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		data = new char[C];
		v = new boolean[C];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < data.length; i++) {
			data[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(data);

		dfs(0, 0);

	}

	static void dfs(int start, int depth) {
		if (depth == L) {
			String answer = "";
			// 모음
			int a = 0;
			// 자음
			int b = 0;
			for (int i = 0; i < C; i++) {
				// 방문 처리 된 위치의 데이터로 확인
				if (v[i]) {
					answer += data[i];
					if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
						a++;
					} else {
						b++;
					}
				}
			}
			if (a >= 1 && b >= 2) {
				System.out.println(answer);
			}
		}

		for (int i = start; i < C; i++) {
			v[i] = true;
			dfs(i + 1, depth + 1);
			v[i] = false;
		}
	}
}