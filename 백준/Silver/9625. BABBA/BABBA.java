import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dpA = new int[46];
	static int[] dpB = new int[46];

	public static void main(String[] args) throws IOException {
		dpA[0] = 1;
		dpA[1] = 0;

		dpB[0] = 0;
		dpB[1] = 1;

		int K = Integer.parseInt(br.readLine());

		for (int i = 2; i <= K; i++) {
			dpA[i]=dpA[i-1] + dpA[i-2];
			dpB[i]=dpB[i-1] + dpB[i-2];
		}
		System.out.println(dpA[K] + " " + dpB[K]);
	}
}