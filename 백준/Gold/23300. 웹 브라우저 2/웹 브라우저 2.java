import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, Q;
	static int now = 0;
	static Deque<Integer> forward = new ArrayDeque<>();
	static Deque<Integer> backward = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			switch (order) {
			// 뒤로가기
			case "B":
				// 비어있는 경우 무시
				if (!backward.isEmpty()) {
					forward.add(now);
					now = backward.pollLast();
				}
				// 앞으로 가기
				break;
			case "F":
				// 비어있는 경우 무시
				if (!forward.isEmpty()) {
					backward.add(now);
					now = forward.pollLast();
				}
				// 접속하기
				break;
			case "A":
				// 처음 실행하는 경우가 아닌 경우
				if (now != 0) {
					// 현재 페이지 저장
					backward.addLast(now);
				}
				now = Integer.parseInt(st.nextToken());
				forward.clear();

				// 압축하기
				break;
			case "C":
				Deque<Integer> newBackward = new ArrayDeque<>();
				while (!backward.isEmpty()) {
					int data = backward.pollLast();
					if (newBackward.isEmpty()) {
						newBackward.add(data);
					} else if (newBackward.getFirst() != data) {
						newBackward.addFirst(data);
					}
					
				}
				backward = newBackward;
			}
		}

		// 현재 페이지
		System.out.println(now);

		// 뒤로 가기 페이지 목록
		if (backward.isEmpty()) {
			System.out.print(-1);
		} else {
			while (!backward.isEmpty()) {
				System.out.print(backward.pollLast() + " ");
			}
		}
		System.out.println();
		// 앞으로 가기 페이지 목록
		if (forward.isEmpty()) {
			System.out.print(-1);
		} else {
			while (!forward.isEmpty()) {
				System.out.print(forward.pollLast() + " ");
			}
		}
	}

}