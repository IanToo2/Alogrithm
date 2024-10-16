import java.io.*;
import java.util.*;
/*
 * 2024.10.16
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			printMessage();
			System.out.print(" ");
		}
	}
	private static void printMessage() {
		System.out.print("LoveisKoreaUniversity");
	}
}
