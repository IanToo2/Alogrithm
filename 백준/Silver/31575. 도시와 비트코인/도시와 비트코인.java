import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n , m ;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean[][] v;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void run() throws Exception {
		Deque<int[]> q = new ArrayDeque<>();
		v[0][0] = true;
		q.add(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == n-1 && cur[1] == m-1) {
				System.out.println("Yes");
				return;
			}
			for(int i = 0 ; i < 2;  i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] || map[nx][ny] == 0) continue;
				v[nx][ny] = true;
				q.add(new int [] {nx,ny});
			}
		}
		System.out.println("No");
	}
}
