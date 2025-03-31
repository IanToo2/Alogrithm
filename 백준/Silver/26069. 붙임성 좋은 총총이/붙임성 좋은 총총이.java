import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		Set<String> answer = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			if("ChongChong".equals(a) || "ChongChong".equals(b) ) {
				answer.add(a);
				answer.add(b);
				continue;
			}
			
			if(answer.contains(a) || answer.contains(b)) {
				answer.add(a);
				answer.add(b);
			}
			
		}
		
		System.out.println(answer.size());
	}
}
