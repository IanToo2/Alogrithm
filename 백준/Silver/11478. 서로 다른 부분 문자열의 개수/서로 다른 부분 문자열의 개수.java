import java.io.*;
import java.util.*;

// 1초 512mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		HashSet<String> set = new HashSet<>();

		String input = br.readLine();

		int size = 1;

		while (size <= input.length()) {
			for (int i = 0; i <= input.length() - size; i++) {
				set.add(input.substring(i, i + size));
			}
			size++;
		}
		System.out.println(set.size());
	}
}
