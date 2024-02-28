import java.io.*;
import java.util.*;

import org.xml.sax.helpers.AttributeListImpl;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {
		int N = Integer.parseInt(br.readLine());
		long result = 1;
		for(int i = 1; i <= N ; i ++) {
			result *= i;
		}
		System.out.println(result);
	}

	public static void run() {
	}
}