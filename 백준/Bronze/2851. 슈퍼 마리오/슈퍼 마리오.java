import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		init();
	}

	private static void init() throws Exception {
		int[] data = new int[11];
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= 10; i++) {
			int value = Integer.parseInt(br.readLine());
			data[i] = data[i - 1] + value;
			if(Math.abs(100 - answer) >= Math.abs(100 - data[i])) {
				answer = data[i];
			}
		}
		System.out.println(answer);
	}
}
