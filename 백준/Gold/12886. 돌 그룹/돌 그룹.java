import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(bfs(A, B, C) ? 1 : 0);
	}

	static boolean bfs(int a, int b, int c) {

		// 세 그룹의 합이 3으로 안 나눠지면 false
		if ((a + b + c) % 3 != 0)
			return false;

		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[1501][1501];

		q.add(new int[] { a, b, c });
		v[a][b] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			a = cur[0];
			b = cur[1];
			c = cur[2];

			// 세 개가 모두 같아지면 true 반환
			if (a == b && b == c) {
				return true;
			}

			// 갯수가 다른 두 개 골라서 연산
			if (a != b) {
				int na = a > b ? a - b : a + a;
				int nb = a > b ? b + b : b - a;

				if (!v[na][nb]) {
					q.add(new int[] { na, nb, c });
					v[na][nb] = true;
				}
			}

			if (b != c) {
				int nb = b > c ? b - c : b + b;
				int nc = b > c ? c + c : c - b;

				if (!v[nb][nc]) {
					q.add(new int[] { a, nb, nc });
					v[nb][nc] = true;
				}
			}

			if (a != c) {
				int na = a > c ? a - c : a + a;
				int nc = a > c ? c + c : c - a;

				if (!v[na][nc]) {
					q.add(new int[] { na, b, nc });
					v[na][nc] = true;
				}
			}

		}

		// Queue가 끝나도 3개가 모두 같아지지 않으면 false 반환
		return false;
	}

}