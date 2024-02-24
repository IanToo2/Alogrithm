import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[] data;
	static int[] sum;
	static int start, end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {

			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

		}

//		for (int a : sum) {
//			System.out.println(a);
//		}

		while (M-- != 0) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			System.out.println(sum[end] - sum[start-1]);
		}
	}
}