import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			init();
			run();
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		List<int[]> data = new ArrayList<>();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data.add(new int[] { a, b });
		}
		Collections.sort(data, (o1, o2) -> {
			return o1[0] - o2[0];
		});
//		System.out.println("Data");
//		for (int[] output : data) {
//			System.out.println(Arrays.toString(output));
//		}
		int answer = 0;
//		System.out.println("Pick");
		int min = -1;
		for (int i = 0; i < t; i++) {
			if (min == -1) {
//				System.out.println(Arrays.toString(data.get(i)));
				answer++;
				min = data.get(i)[1];
			}
			if (min > data.get(i)[1]) {
				answer++;
				min = data.get(i)[1];
			}
		}
		sb.append(answer).append("\n");
	}

	private static void run() {

	}
}
