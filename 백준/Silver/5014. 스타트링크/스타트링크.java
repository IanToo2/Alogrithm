import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int F, S, G, U, D;
	static boolean v[];

	public static void main(String[] args) throws Exception {
		init();
		logic();

	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		// 전체 층수
		F = Integer.parseInt(st.nextToken());
		v = new boolean[F + 1];
		// 강호 위치
		S = Integer.parseInt(st.nextToken());
		// 스타트링크 위치
		G = Integer.parseInt(st.nextToken());
		// + U만큼
		U = Integer.parseInt(st.nextToken());
		// - D만큼
		D = Integer.parseInt(st.nextToken());
	}

	public static void logic() throws Exception {
		bfs();
	}

	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		v[S] = true;
		q.add(new int[] { S, 0 });
		while (!q.isEmpty()) {
			int[] now = q.poll();
//			System.out.println(now[0] + "," + now[1]);
			if (now[0] == G) {
				System.out.println(now[1]);
				return;
			}

			if (now[0] + U <= F && !v[now[0] + U]) {
				v[now[0] + U] = true;
				q.add(new int[] { now[0] + U, now[1] + 1 });
			}

			if (now[0] - D > 0 && !v[now[0] - D]) {
				v[now[0] - D] = true;
				q.add(new int[] { now[0] - D, now[1] + 1 });
			}
		}
		System.out.println("use the stairs");
	}

	public static void printMap() {
	}
}