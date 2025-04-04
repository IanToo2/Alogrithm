import java.io.*;
import java.util.*;

// 1s, 1024mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int[] bin = new int[8];
		int[] answer = new int[] {0,1,2,3,4,5,6,7};
		
		bin[0] = 1;
		for (int i = 1; i < 8; i++) {
			bin[i] = bin[i - 1] * 2;
		}

		HashMap<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			for (int j = i; j < 8; j++) {
				if (map.get(bin[i] + bin[j]) == null && i != j) {
					map.put(bin[i] + bin[j], new int[] { i, j });
				}
			}
		}

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int order = Integer.parseInt(st.nextToken());
			if(map.get(order) == null) {
				continue;
			}
			int[] now = map.get(order);
			int temp = -1;
			
			temp = answer[now[0]];
			answer[now[0]] = answer[now[1]];
			answer[now[1]] = temp;
			
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(answer[k]);
	}
}
