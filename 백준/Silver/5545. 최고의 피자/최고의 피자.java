import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int toppingCnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long doughCost = Long.parseLong(st.nextToken());
		int toppingCost = Integer.parseInt(st.nextToken());

		long doughCal = Long.parseLong(br.readLine());
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < toppingCnt; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr, Collections.reverseOrder());
		long answer = doughCal / doughCost;
//		System.out.println("도우만 고른 경우 : " + answer);
		for (int i = 0; i < toppingCnt; i++) {
//			System.out.println("도우 : " + arr.get(i));
			doughCal += arr.get(i);
//			System.out.println("total Cal : " + doughCal);
			doughCost += toppingCost;
//			System.out.println("total Cost : " + doughCost);
//			System.out.println(doughCal / doughCost);
			if (doughCal / doughCost >= answer) {
				answer = doughCal / doughCost;
			} else {
				break;
			}
		}
//		System.out.println("정답 : " + answer);
		System.out.println(answer);

	}

	private static void run() throws Exception {

	}

}
