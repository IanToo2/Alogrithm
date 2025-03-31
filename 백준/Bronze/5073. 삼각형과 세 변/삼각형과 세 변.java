import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		while(true) {
			st = new StringTokenizer(br.readLine());
			int max = -1;
			int sum = 0;
			
			int a = Integer.parseInt(st.nextToken());
			max = Integer.max(max,a);
			int b = Integer.parseInt(st.nextToken());
			max = Integer.max(max,b);
			int c = Integer.parseInt(st.nextToken());
			max = Integer.max(max,c);
			
			if(a == 0 && b == 0 && c == 0) {
				System.out.println(sb);
				return;
			}
			
			sum = a + b + c;
			if(max >= (sum-max)) {
				sb.append("Invalid");
			}
			else if(a == b && b == c) {
				sb.append("Equilateral");
			}
			else if ( a != b && b != c && a != c) {
				sb.append("Scalene");
			}else {
				sb.append("Isosceles");
			}
			sb.append("\n");
			
		}
	}
}
