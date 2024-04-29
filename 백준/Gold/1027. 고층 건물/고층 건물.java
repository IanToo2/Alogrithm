import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] data;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		answer = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void run() {
		// 건물 A에서 건물 B가 보인다는 것은 건물 B에서도 건물 A를 볼 수 있다.

		// 우측으로만 연산
		for (int i = 0; i < n - 1; i++) {
			// 바로 옆에 있는 건물은 반드시 볼 수 있다.
			answer[i]++;
			answer[i + 1]++;
			// 기울기
			double value = data[i + 1] - data[i];
			// 우측 데이터들 확인
			for (int j = i + 2; j < n; j++) {
				double nValue = (double) (data[j] - data[i]) / (j - i);
				if (nValue > value) {
					answer[i]++;
					answer[j]++;
					value = nValue;
				}
			}

		}
		// 정답 구하기
		int max = 0;
		for (int output : answer) {
			if (max < output) {
				max = output;
			}
		}
		System.out.println(max);
	}

}
