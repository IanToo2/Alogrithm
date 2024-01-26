import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		ArrayList<Integer> change = new ArrayList<>();
		int[] data = new int[input.length()];
		// start input data
		for (int i = 0; i < data.length; i++) {
			data[i] = (input.charAt(i) == 'Y') ? 0 : 1;
		}
		// end

		// 데이터 순회
		for (int i = 0; i < data.length; i++) {
			// data에 저장된 값을 비교하기 전에 change에 저장된 값의 배수인지 확인하고 몇번 반전이 일어났는지 체크한다.
			int count = 0;
			if (!change.isEmpty()) {
				for (int j = 0; j < change.size(); j++) {
					if ((i + 1) % change.get(j) == 0) {
						count += 1;
					}
				}
			}
			// data가 짝수인 경우 On
			// change에 저장해서 해당 배수가 반전된다는 것을 저장
			// ex) 0번 인덱스 짝수인 경우 1번 전구이기에 1 저장
			if ((data[i]+count) % 2 == 0) {
				change.add(i + 1);
			}
			// data가 홀수인 경우 Off

		}
		System.out.println(change.size());
	}
}