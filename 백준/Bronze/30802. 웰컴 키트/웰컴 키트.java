import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		int[] size = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size.length; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for(int cur : size) {
			answer += cur/t;
			if(cur%t != 0) {
				answer++;
			}
		}
		System.out.println(answer);
		System.out.println(n/p + " " + n%p);
	}
}
