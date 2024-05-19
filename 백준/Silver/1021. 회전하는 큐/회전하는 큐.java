import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int m;
	static Deque<Integer> q = new ArrayDeque<>();
		
	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n ; i++) {
			q.add(i);
		}
		m = Integer.parseInt(st.nextToken());
		
	}

	private static void run() throws Exception {
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreElements()) {
			
			int value = Integer.parseInt(st.nextToken());
			answer += findValue(value);
		}
		
		System.out.println(answer);
	}
	
	private static int findValue(int value) {
		
		int cur = 0;
		int cnt = 0;
		int len = q.size();
		
		while(true) {
			cur = q.poll();
			
			if(cur == value) {
				break;
			}
			cnt++;
			q.add(cur);
			
		}
		
		if(cnt > len/2) {
			cnt = len - cnt;
		}
//		System.out.println(cnt);
		return cnt;
	}
}
