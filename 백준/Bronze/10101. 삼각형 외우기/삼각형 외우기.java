import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());

		if (a + b + c != 180) {
			System.out.println("Error");
		} else if (a == b && b == c && a == 60) {
			System.out.println("Equilateral");
		} else if (a + b + c == 180 && a != b && a != c && b != c) {
			System.out.println("Scalene");
		} else {
			System.out.println("Isosceles");
		}

	}
}