import java.io.*;
import java.util.*;

public class Main {
	
	static StringTokenizer st;
	static StringBuilder sb= new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));
		sb.append(a).append(b);
		int data = Integer.parseInt(sb.toString());
		System.out.println(data - Integer.parseInt(c));
	}
}
