import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, problem;
	static long targetCnt;
	static int[] targetData;
	static int[] answerData;
	static long[] storage;
	static boolean[] v;
	static List<Integer> num;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		v = new boolean[n + 1];
		num = new ArrayList<>();
		for(int i = 1; i <= n ;i++) {
			num.add(i);
		}
		st = new StringTokenizer(br.readLine());
		problem = Integer.parseInt(st.nextToken());

		if (problem == 1) {
			answerData = new int[n];
			targetCnt = Long.parseLong(st.nextToken());
		} else {
			targetData = new int[n];
			for (int i = 0; i < n; i++) {
				targetData[i] = Integer.parseInt(st.nextToken());
			}
		}
		storage = new long[21];
		storage[1] = 1;
		for (int i = 2; i < 21; i++) {
			storage[i] = storage[i - 1] * i;
		}
	}

	private static void run() {
//		int size = findSize();
		// cnt로 data 찾기
		if (problem == 1) {
			for (int i = 0; i < n; i++) {
				long nowSize = storage[n - i] / (n - i);
				int nowCur = 1;
				while(true) {
					if(targetCnt <= nowSize) {
						answerData[i] = num.get(nowCur -1);
						num.remove(nowCur-1);
						break;
					}
					targetCnt -= nowSize;
					nowCur++;
				}
			}
			for(int output : answerData) {
				System.out.print(output + " ");
			}
		}
		// data로 cnt 찾기
		else {
			long size = storage[n];
			for (int i = 0; i < n; i++) {
				int cnt = 1;
				for (int j = 1; j <= n; j++)
					if (targetData[i] == j) {
						size -= storage[n - i] / (n - i) * (n - i - cnt);
						v[j] = true;
					} else if (!v[j]) {
						cnt++;
					}
			}
			System.out.println(size);
		}
	}

//	private static int findSize() {
//		int size = 1;
//		int depth = 1;
//
//		while (true) {
//			if (depth > n)
//				break;
//
//			size *= depth;
//			depth++;
//		}
//		return size;
//	}
}
