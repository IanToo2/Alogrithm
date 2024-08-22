import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			sb.append("#").append(i + 1).append(" ").append(init()).append("\n");
		}
		System.out.println(sb);
	}

	private static int init() throws Exception {
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int last = 0;
		
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i = 0 ; i < n ; i++) {
			int value = Integer.parseInt(br.readLine());
			q.add(value);
			sum += value;
		}

		int avg = sum / n;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur > avg) {
				last += cur-avg;
			}
		}
		
		return last;
	}
}
