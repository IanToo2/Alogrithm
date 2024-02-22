import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static List<Meat> data = new ArrayList<>();

	private static class Meat implements Comparable<Meat> {

		int weight;
		int price;

		public Meat(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Meat o) {
			if (this.price == o.price) {
				return o.weight - this.weight;
			} else {
				return this.price - o.price;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 고기 덩어리 수
		M = Integer.parseInt(st.nextToken()); // 필요한 고기의 양

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			data.add(new Meat(weight, price));
		}
	}

	public static void run() throws Exception {
		Collections.sort(data);

		int totalWeight = data.get(0).weight;
		int totalPrice = data.get(0).price;

		int result = Integer.MAX_VALUE;

		boolean flag = false;

		for (int i = 1, size = data.size(); i < size; i++) {
			if (data.get(i).price == data.get(i - 1).price) { // 가격이 같은 경우
				totalPrice += data.get(i).price;
			} else { // 가격이 다른 경우
				totalPrice = data.get(i).price;
			}

			totalWeight += data.get(i).weight;

			if (totalWeight >= M) {
				flag = true;
				result = Math.min(result, totalPrice);
			}
		}

		System.out.println(flag ? result : -1);
	}
}