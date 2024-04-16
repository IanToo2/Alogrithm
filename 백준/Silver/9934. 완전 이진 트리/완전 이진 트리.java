import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int[] data;
	static List<Integer>[] layer;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		layer = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			layer[i] = new ArrayList<Integer>();
		}
		data = new int[(int) Math.pow(2, n) - 1];
		int dataLen = (int) Math.pow(2, n) - 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dataLen; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void run() {
		recur(0, (int) Math.pow(2, n) - 1, 1);
		for(int i = 1; i <= n ; i++) {
//			Collections.sort(layer[i]);
			for(int output : layer[i]) {
				System.out.print(output + " ");
			}System.out.println();
		}
	}

	private static void recur(int start, int end, int depth) {
		if (depth > n) {
			return;
		}
		int now = (end + start) / 2;
		layer[depth].add(data[now]);
		recur(start, now - 1, depth + 1);
		recur(now + 1, end, depth + 1);
		
	}
}
