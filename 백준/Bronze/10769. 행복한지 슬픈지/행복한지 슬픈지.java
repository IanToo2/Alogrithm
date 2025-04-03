import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		String input = br.readLine();
		int size = input.length();
		int sadCnt = 0;
		int happyCnt = 0;

		for (int i = 0; i < size - 3; i++) {
			String cur = input.substring(i, i + 3);
			if (":-)".endsWith(cur)) {
				happyCnt++;
			} else if (":-(".equals(cur)) {
				sadCnt++;
			}
		}
		if (sadCnt == 0 && happyCnt == 0) {
			System.out.println("none");
		} else if (sadCnt == happyCnt) {
			System.out.println("unsure");
		} else if (sadCnt > happyCnt) {
			System.out.println("sad");
		} else if (sadCnt < happyCnt) {
			System.out.println("happy");
		}

	}
}
