import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		int n = Integer.parseInt(br.readLine());
		int result = 1;
		long[] data = new long[1_000_000 + 1];
		data[1] = 0;
		data[2] = 1;
		if (n >= 3) {
			for (int i = 3; i <= n; i++) {
				data[i] = (data[i - 1] * (i - 1) + data[i - 2] * (i - 1)) % 1_000_000_000;
			}
		}
//		System.out.println(Arrays.toString(data));
		System.out.println(data[n]);
	}

	private static void run() {

	}
}
