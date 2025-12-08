import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		char[] input = br.readLine().toCharArray();
		for(int i = 0 ; i < input.length; i++) {
			System.out.print(input[i]);
			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}

}
