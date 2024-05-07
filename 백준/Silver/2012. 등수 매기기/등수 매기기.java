import java.io.*;
import java.util.*;

public class Main {

	static List<Integer> arr;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<>();

		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(arr);
	}

	private static void run() throws Exception {
		long result = 0;

		for (int i = 0; i < arr.size(); i++) {
//			System.out.println((i+1) + " : " + arr.get(i));
			result += Math.abs(arr.get(i) - (i + 1));
		}
		System.out.println(result);
	}

}
