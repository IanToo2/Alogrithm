import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			int value = Integer.parseInt(st.nextToken());
			pq.add(value);
		}
		int answer = 0;
		while(pq.size() != 1) {
			int a = pq.poll();
			int b=  pq.poll();
			answer += a*b;
			pq.add(a+b);
		}
		System.out.println(answer);
	}
	
}
