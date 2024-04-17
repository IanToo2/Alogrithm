import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws Exception{
		int input = Integer.parseInt(br.readLine());
		System.out.print(input / 100 * 78 + " ");
		System.out.println((int)(input * 0.8 + input * 0.2 / 100 * 78));
	}
}
