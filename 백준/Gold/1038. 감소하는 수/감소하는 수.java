import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] data;
	static int totalCnt = -1;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
	}

	public static void run() {
		for (int i = 1; i <= 10; i++) {
			data = new int[i];
			recur(0);
		}
		if(totalCnt!=n) {
			System.out.println(-1);
		}
	}

	public static void recur(int depth) {

		if (depth == data.length) {
			totalCnt++;

//			System.out.println(Arrays.toString(data));
			if (totalCnt == n) {
				for(int output : data) {
					System.out.print(output);
				}
				System.exit(0);
			}
			return;
		}
		if (depth == 0) {
			for (int i = 0; i < 10; i++) {
				data[depth] = i;
				recur(depth + 1);
			}
		} else {
			for (int i = 0; i < data[depth - 1]; i++) {
				data[depth] = i;
				recur(depth + 1);
			}
		}
	}
}
