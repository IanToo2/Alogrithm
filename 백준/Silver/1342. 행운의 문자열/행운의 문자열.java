import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] charData;
	static boolean[] v;
	static HashSet<String> data = new HashSet<>();
	static int[] answer;
	static int[] alpha = new int[26];
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		charData = br.readLine().toCharArray();
		for (int i = 0; i < charData.length; i++) {
			alpha[charData[i] - 'a'] += 1;
		}

//		for (int asgfshlkhk : alpha) {
//			System.out.println(asgfshlkhk);
//		}
		answer = new int[charData.length];

		dfs(answer, 0);
//		System.out.println(data.size());
		System.out.println(cnt);
	}

	static void dfs(int[] answer, int depth) {
		// 종료 조건
		// 길이가 전체 데이터 길이랑 동일한 경우 종료
		if (depth == charData.length) {
//			data.add(answer.toString());
			cnt +=1;
			return;
		}

		// 수행 로직
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] != 0 && (depth == 0 || answer[depth - 1] != i)) {
				answer[depth] = i;
				alpha[i] -= 1;
				dfs(answer, depth + 1);
				alpha[i] += 1;
			}
		}
	}

}