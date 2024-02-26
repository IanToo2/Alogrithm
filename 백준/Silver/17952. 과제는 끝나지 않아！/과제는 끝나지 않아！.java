import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	// 업무 정보 저장
	static ArrayList<int[]> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
//		print();
		logic();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nowTime = Integer.parseInt(st.nextToken());

			// 업무가 없는 경우
			if (nowTime == 0) {
				data.add(new int[3]);
				continue;
			}

			// 업무가 있는 경우
			int startTime = nowTime;
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			data.add(new int[] { startTime, score, time });
		}
	}

	public static void logic() {
		Deque<int[]> q = new LinkedList<>();

		int score = 0;
		int[] now = new int[2];

		for (int[] work : data) {
			
			// 아무런 작업이 안들어온 경우
			// 하던일이 있으면 계속 진행
			if (work[0] == 0) {
				if (now[1] != 0) {
					now[1]--;
					// 하던 일이 끝난 경우
					if (now[1] == 0) {
//						System.out.println("점수 추가" + now[0]);
						score += now[0];
						// 밀린 일이 있는 경우
						if (!q.isEmpty()) {
							now = q.pollLast();
						} else {
							now = new int[2];
						}
					}
				}
			}

			// 작업이 들어온 시간
			else {
				int[] next = new int[] { work[1], work[2] };

				// 아무런 작업도 안하고 있는 경우
				if (now[1] == 0) {
					now = next;
					// 들어온 작업은 실행
					// time--;
					now[1]--;
					// 바로 작업을 완료한 경우
					if (now[1] == 0) {
						// 점수 추가
//						System.out.println("점수 추가" + now[0]);
						score += now[0];
						// 작업 중인 데이터 초기화
						now = new int[2];
					}
				}
				// 작업중인 경우
				else {
					// 스택에 하던 일 저장
					q.add(now);
					now = next;
					now[1]--;
					if (now[1] == 0) {
//						System.out.println("점수 추가" + now[0]);
						score += now[0];
						now = q.pollLast();
					}
				}

			}
//			System.out.println(now[0]+","+now[1]);
		}
		System.out.println(score);
	}

	public static void print() {
		for (int[] output : data) {
			System.out.println(output[0] + "," + output[1] + "," + output[2]);
		}
	}
}
