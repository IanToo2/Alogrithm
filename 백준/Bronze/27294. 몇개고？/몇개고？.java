import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		init();
		run();
	}
	private static void init() throws Exception{
		int t, s;
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		if(s == 1 || t <= 11 || t >= 17) {
			System.out.println(280);
		}else if(t >= 12 && t <= 16 && s == 0) {
			System.out.println(320);
		}
	}
	private static void run() {
		
	}
}
