import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		// 전체 테스크 케이스
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			// 해당 케이스에서 입력받을 데이터 수
			int count = Integer.parseInt(br.readLine());

			HashMap<String, Integer> total = new HashMap<>();

			while (count-- > 0) {

				st = new StringTokenizer(br.readLine());
				st.nextToken();
				// 옷 종류
				String key = st.nextToken();

				// 데이터 저장
				total.put(key, total.getOrDefault(key, 0) + 1);
			}
			// values 값 가져오기
			int result = 1;
			for(int num : total.values()) {
				result *= (num+1);
			}
			System.out.println(result-1);
			// key 값 가져오기
//			for(String s : total.keySet()) {
//				
//			}
			// key value 형식으로 가져오기
//			for(Entry<String, Integer> entry : total.entrySet()) {
//				asd += entry.getValue();
//			}
		}

//		HashMap<String, HashSet<String>> map = new HashMap<>();
//		
//		HashSet<String> set  = map.getOrDefault("abc", new HashSet<>());
//		set.add("set");
//		map.put("abc", set);
	}

}