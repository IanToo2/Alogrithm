import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, m, totalCnt;
	static int[] xCnt, yCnt;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		xCnt = new int[n];
		
		m = Integer.parseInt(st.nextToken());
		yCnt = new int[m];
		
		totalCnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				char[] charArr = st.nextToken().toCharArray();
				
				for(char cur : charArr) {
					if(cur == '9') {
						totalCnt++;
						xCnt[i]++;
						yCnt[j]++;
					}
				}
			}
		}
		
		int max = -1;
		for(int cur : xCnt) {
			max = Integer.max(max,cur);
		}
		for(int cur : yCnt) {
			max = Integer.max(max,cur);
		}
		System.out.println(totalCnt - max);
	}
}
