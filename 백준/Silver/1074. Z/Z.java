import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, r, c;
	static int[][] map;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		int size = 1;

		for (int i = 1; i <= N; i++) {
			size = size * 2;
		}
//		System.out.println(size);
		partition(0, 0, size);
	}

	public static void partition(int x, int y, int size) {
//		System.out.println("size, count : " + size + ", " + count);
		if (size > 1) {
			int newsize = size / 2;
			if (r < x + size / 2) {
				// 2
				if (c < y + size / 2) {
					partition(x, y, newsize);
				}
				// 1
				else {
					count += newsize * newsize;
					partition(x, y + newsize, newsize);
				}
			} else {
				// 3
				if (c < y + size / 2) {
					count += 2 * newsize * newsize;
					partition(x + newsize, y, newsize);
				}
				// 4
				else {
					count += 3 * newsize * newsize;
					partition(x + newsize, y + newsize, newsize);
				}
			}
		} else {
			System.out.println(count);
			System.exit(0);
		}
	}
}
