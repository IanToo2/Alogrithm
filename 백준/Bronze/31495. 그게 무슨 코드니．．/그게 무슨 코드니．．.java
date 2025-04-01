import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		String input = br.readLine();
		char[] charArr = input.toCharArray();
		if (charArr.length < 2 || charArr[0] != '\"' || charArr[charArr.length - 1] != '\"') {
			System.out.println("CE");
			return;
		}

		boolean flag = false;
		for (int i = 1; i < charArr.length - 1; i++) {
			if (flag) {
				sb.append(charArr[i]);
			} else {
				if (charArr[i] != ' ') {
					flag = true;
					sb.append(charArr[i]);
				}
			}
		}
		if (flag) {
			System.out.println(sb.toString());
		} else {
			System.out.println("CE");
		}
	}
}
