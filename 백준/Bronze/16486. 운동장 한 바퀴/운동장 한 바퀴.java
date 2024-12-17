import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		System.out.println( (a*2) + (3.141592 * 2 * b));
	}
}
