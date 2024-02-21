import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, map[][];
	// 8방향 이동용
	static int dictx[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dicty[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	// 대각선 확인용
	static int checkX[] = { -1, -1, 1, 1 };
	static int checkY[] = { -1, 1, 1, -1 };
	// 구름이 생겼던 구역을 제외하기 위한 boolean[][]
	static boolean v[][];
	// 구름
	static ArrayDeque<int[]> cloud = new ArrayDeque<>();
	// 데이터 저장용
	static ArrayList<int[]> check = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		input();
//		System.out.println("초기 세팅");
//		print();
		logic();
		System.out.println(answer());
	}

	public static void logic() throws Exception {
		// M번 로직 수행
		for (int time = 0; time < M; time++) {
			st = new StringTokenizer(br.readLine());
			// x,y 좌표값 저장
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			// 처음 실행하는 경우
			if (time == 0) {
				init();
			}
			// 구름 움직이기 및 비내리기
			firstLogic(d, s);
			// 대각선 확인하기
			secondLogic();
			// 전체 순회
			lastLogic();
			// 확인용 출력
//			print();
		}
	}

	public static void init() {
		// 처음 시작하는 경우
		cloud.add(new int[] { N - 1, 0 });
		cloud.add(new int[] { N - 1, 1 });
		cloud.add(new int[] { N - 2, 0 });
		cloud.add(new int[] { N - 2, 1 });
	}

	public static void firstLogic(int d, int s) {

		int size = cloud.size();
		
		for (int i = 0; i < size; i++) {
			
			int[] cur = cloud.pollFirst();
			// s만큼 작동
			for (int j = 0; j < s; j++) {
				cur[0] = cur[0] + dictx[d];
				cur[1] = cur[1] + dicty[d];
				// x값
				if (cur[0] == N) {
					cur[0] = 0;
				} else if (cur[0] == -1) {
					cur[0] = N - 1;
				}
				// y값
				if (cur[1] == N) {
					cur[1] = 0;
				} else if (cur[1] == -1) {
					cur[1] = N - 1;
				}
			}

			// 비 내리기
			map[cur[0]][cur[1]]++;
			// 다음 로직에서 제외
			v[cur[0]][cur[1]] = true;

			check.add(cur);
		}
	}

	public static void secondLogic() {
		for (int i = 0; i < check.size(); i++) {
			int count = 0;
			for (int j = 0; j < 4; j++) {
				int nowx = check.get(i)[0] + checkX[j];
				int nowy = check.get(i)[1] + checkY[j];

				if (nowx < N && 0 <= nowx && nowy < N && 0 <= nowy && map[nowx][nowy] > 0) {
					count++;
				}
			}
			map[check.get(i)[0]][check.get(i)[1]] += count;
		}
	}

	public static void lastLogic() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !v[i][j]) {
					map[i][j] -= 2;
					cloud.add(new int[] { i, j });
				}
			}
		}
		check.clear();
		v = new boolean[N][N];
	}

	public static int answer() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;

	}

	// 입력 받기
	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	// 출력 함수
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("다음 연산에 사용될 구름 개수 : " + cloud.size());
		System.out.println(check.size());
		System.out.println("-----------------------------------------------");
	}
}
