import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int k, power, answer;
	static int[] kit;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		init();
		recur(0, power);
		System.out.println(answer);
	}
	
	private static void recur(int depth, int power) {
//		System.out.println("now stat");
//		System.out.println(depth + " , " + power);
		if(power < 500) {
//			System.out.println("power under 500");
			return;
		}
		if(depth == kit.length) {
//			System.out.println("answer++");
			answer++;
			return;
		}
	
		for(int i = 0 ; i < kit.length; i++) {
			if(!v[i]) {
				v[i] = true;
//				System.out.println("next step");
				recur(depth+1, power - k + kit[i]);
				v[i] = false;
			}
		}
	}
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		int kitSize = Integer.parseInt(st.nextToken());
		kit = new int[kitSize];
		v = new boolean[kitSize];
		
		k = Integer.parseInt(st.nextToken());
		power = 500;
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < kitSize ; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
	}

}
