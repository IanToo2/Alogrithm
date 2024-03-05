import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		init();
	}

	public static void init() throws Exception {
		String s = Integer.toBinaryString(Integer.parseInt(br.readLine())+1);
//		System.out.println(s);
		sb = new StringBuilder();
		for(int i = 1 ; i < s.length();i++) {
			if(s.charAt(i)=='0') {
				sb.append('4');
			}else {
				sb.append('7');
			}
		}
		System.out.println(sb);
	}

	public static void run() {

	}

	public static void print() {

	}
}
