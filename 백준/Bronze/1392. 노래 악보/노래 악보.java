import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int index = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j < data[i]; j++) {
				answer.add(i+1);
			}
		}

		for (int i = 0; i < q; i++) {
			int input = Integer.parseInt(br.readLine());
			System.out.println(answer.get(input));
		}
	}
}
