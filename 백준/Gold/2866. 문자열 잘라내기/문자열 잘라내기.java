import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int R, C;

	static StringBuilder[] StringData;

	static char[] charData;

	static HashSet<String> answer = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		StringData = new StringBuilder[C];
		charData = new char[C];
		// 초기화
		for (int i = 0; i < C; i++) {
			StringData[i] = new StringBuilder();
		}
		// 입력
		for (int x = 0; x < R; x++) {
			charData = br.readLine().toCharArray();
			for (int y = 0; y < C; y++) {
				StringData[y].append(charData[y]);
			}
		}
//		for (StringBuilder asd : StringData) {
//			answer.add(asd);
//		}
		int cnt = 0;
		int aaaaa = 0;
		// 로직
		while (aaaaa++ < R) {
			for (int i = 0; i < C; i++) {
				StringData[i] = StringData[i].deleteCharAt(0);
				if (answer.contains(StringData[i].toString())) {
					System.out.println(cnt);
					return;
				} else {
					answer.add(StringData[i].toString());
				}

			}
			answer.clear();
			cnt += 1;	
		}
		
		System.out.println(cnt);

	}

}