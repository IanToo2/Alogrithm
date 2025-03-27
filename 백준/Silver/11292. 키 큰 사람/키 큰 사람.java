import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static float max = 0;
	
	public static void main(String[] args) throws Exception{
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				System.out.print(sb);
				break;
			}
			
			Map<Float, ArrayList<String>> treeMap = new TreeMap<>();
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();
				float size = Float.parseFloat(st.nextToken());
				
				treeMap.computeIfAbsent(size, k -> new ArrayList<>()).add(name);
				max = Float.max(max, size);
			}
			
			ArrayList<String> result = treeMap.get(max);
			for(String cur : result) {
				sb.append(cur).append(" ");
			}
			sb.append("\n");
			
			max = 0;
		}
	}

}
