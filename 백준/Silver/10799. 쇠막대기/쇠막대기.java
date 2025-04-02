import java.io.*;
import java.util.*;

// 1초 256mb
public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		char[] input = br.readLine().toCharArray();
		int answer = 0;
		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(') {
				s.push(input[i]);
			}else {
				if(input[i-1] == '(') {
					s.pop();
					answer += s.size();
				}else {
					answer++;
					s.pop();
				}
			}
		}
		System.out.println(answer);
	}
}
