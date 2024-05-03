import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		init();

	}

	private static void init() throws Exception {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		if(n % 2 == 0 ) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}

	private static void run() {

	}
}
