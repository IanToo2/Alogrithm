import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			sb.append("#").append(i + 1).append(" ").append(logic()).append("\n");
		}
		System.out.println(sb);
	}

	private static int logic() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> totalData = new HashMap<>();
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < left; i++) {
			String value = st.nextToken();
			totalData.put(value, 0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < right; i++) {
			String value = st.nextToken();
			if(totalData.containsKey(value)) {
				answer++;
			}
		}
		return answer;
	}
}
