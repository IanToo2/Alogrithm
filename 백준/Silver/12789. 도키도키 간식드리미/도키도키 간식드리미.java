import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static Deque<Integer> q = new ArrayDeque<>();
	static Deque<Integer> keep = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
	}

	private static void run() {
		int index = 1;
		boolean check = true;

		while (true) {
			// 종료 조건
			if (q.isEmpty() && keep.isEmpty()) {
				break;
			}
			// 기존 대기열이 존재하는 경우
			if (!q.isEmpty()) {
				int cur = q.poll();
//				System.out.println(cur);
				if (cur > index) {
					if (!keep.isEmpty()) {
						int keepCur = keep.pollLast();
						if (keepCur == index) {
							index++;
							q.addFirst(cur);
							continue;
						}else{
							keep.addLast(keepCur);
//							System.out.println("add Keep");
							keep.add(cur);
							continue;
						}
					} else {
//						System.out.println("add Keep");
						keep.add(cur);
						continue;
					}
				}
				// 줄서기 성공한 경우
				else if (cur == index) {
//					System.out.println("OK");
					index++;
					continue;
				} else {
					q.addFirst(cur);
					int keepCur = keep.pollLast();
					if (keepCur == index) {
//						System.out.println("OK");
						index++;
						continue;
					}
				}
			}
			// keep에서 모든 연산을 진행해야하는 경우
			else {
				int cur = keep.pollLast();
//				System.out.println(cur);
				if (cur != index) {
					check = false;
					break;
				} else {
					index++;
					continue;
				}
			}

		}

		if (check)

		{
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
