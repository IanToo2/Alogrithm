import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static List<Integer>[] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받을 정점 수
		n = Integer.parseInt(br.readLine());
		List<Integer>[] tree = new List[n + 1];
		// 값을 저장할 배열 
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		// 값 입력
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 간선
			tree[a].add(b);
			tree[b].add(a);
		}
		// 입력받을 질의 개수
		int q = Integer.parseInt(br.readLine());
		// 질의 시작
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 단절점 질의
			if (t == 1) {
				if (tree[k].size() >= 2)
					System.out.println("yes");
				else
					System.out.println("no");
			}
			// 단절선 질의
			// 정점이 1개만 있더라도 그래프로 인정한다..
			else {
				System.out.println("yes");
			}
		}
	}
}
