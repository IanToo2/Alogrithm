import java.io.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 시험장 수
	static int N;
	// 총 감독관, 부 감독관 관리 가능 인원
	static int B, C;
	// 시험장별 응시자 수
	static int person[];
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	public static void init() throws Exception {

		N = Integer.parseInt(br.readLine());

		person = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}

	public static void run() {
		for (int data : person) {
			// 총 감독관 배치
			if (data >= B) {
				data = data - B;
				answer++;
			} else {
				answer ++;
				continue;
			}
			// 부 감독관 배치
			answer += data / C;
			if (data % C != 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}