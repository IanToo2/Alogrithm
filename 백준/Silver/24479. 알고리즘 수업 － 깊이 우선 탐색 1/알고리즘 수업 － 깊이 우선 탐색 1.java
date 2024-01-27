import java.io.*;
import java.util.*;

public class Main {
	static int[] answer;
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	static int idx = 0;
	
	public static void dfs(int cur) {
		answer[cur] = ++idx;
		for(int next : edge[cur]) {
			// 방문한 경우 스킵
			if (visited[next]) {
				continue;
			}
			visited[next] = true;
			dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N, M, R 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 초기값 세팅
		visited = new boolean[N + 1];
		edge = new ArrayList[N + 1];
		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}
		// u, v 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edge[u].add(v);
			edge[v].add(u);
		}
		// 오름차순으로 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(edge[i]);
		}
		// 로직 시작
		visited[R] = true;
		dfs(R);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1;i<=N;i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.println(sb);
	}
}
