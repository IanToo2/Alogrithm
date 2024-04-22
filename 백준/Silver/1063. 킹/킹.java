import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int orderCnt;
	static int[] k = new int[2];
	static int[] s = new int[2];
	static int[] dx = { 0, 0, 1, -1, -1, -1, 1, 1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		char x = king.charAt(0);
		char y = king.charAt(1);
		k[0] = 8 - (y - '0');
		k[1] = x - '0' - 17;

		String stone = st.nextToken();
		x = stone.charAt(0);
		y = stone.charAt(1);
		s[0] = 8 - (y - '0');
		s[1] = x - '0' - 17;

		orderCnt = Integer.parseInt(st.nextToken());

	}

	private static void run() throws Exception {
		for (int i = 0; i < orderCnt; i++) {
//			System.out.println(i);
//			System.out.println(Arrays.toString(k));
//			System.out.println(Arrays.toString(s));

			String order = br.readLine();

			int orderType = checkOrder(order);
			int nx = k[0] + dx[orderType];
			int ny = k[1] + dy[orderType];
			// king이 맵 밖으로 나가는 경우
			if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) {
				continue;
			}
			// 돌과 같은 곳으로 이동하는 경우
			if (nx == s[0] && ny == s[1]) {
				int nsx = s[0] + dx[orderType];
				int nsy = s[1] + dy[orderType];
				// stone이 맵 밖으로 나가는 경우
				if (nsx < 0 || nsy < 0 || nsx >= 8 || nsy >= 8) {
					continue;
				}
				s[0] = nsx;
				s[1] = nsy;
				k[0] = nx;
				k[1] = ny;
			}
			// 아닌 경우
			else {
				k[0] = nx;
				k[1] = ny;
			}

		}
//		System.out.println(Arrays.toString(k));
//		System.out.println(Arrays.toString(s));

		System.out.print((char) (k[1] + 65));
		System.out.print(8 - k[0]);
		System.out.println();
		System.out.print((char) (s[1] + 65));
		System.out.print(8 - s[0]);
	}

	private static int checkOrder(String order) {
		if (order.equals("R")) {
			return 0;
		} else if (order.equals("L")) {
			return 1;
		} else if (order.equals("B")) {
			return 2;
		} else if (order.equals("T")) {
			return 3;
		} else if (order.equals("RT")) {
			return 4;
		} else if (order.equals("LT")) {
			return 5;
		} else if (order.equals("RB")) {
			return 6;
		} else {
			return 7;
		}
	}

}
