import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int nrow;
	static int ncol;
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {-1, 1, 0, 0};
	static char[][] matrix;
	static boolean[][] visited;
	static Queue<int[]> hQueue = new ArrayDeque<int[]>();
	static Queue<int[]> wQueue = new ArrayDeque<int[]>();
	static Queue<int[]> nhQueue = new ArrayDeque<int[]>();
	static Queue<int[]> nwQueue = new ArrayDeque<int[]>();

	public static String solution() {
		int cnt = 1;
		while(true) {
			while(!hQueue.isEmpty()) {
				int[] node = hQueue.poll();
				if(matrix[node[0]][node[1]]=='*')
					continue;
				for(int i=0; i<4; i++) {
					int y = node[0] + dy[i];
					int x = node[1] + dx[i];
					if(y<0 || y>=nrow || x<0 || x>=ncol)
						continue;
					if(!visited[y][x] && matrix[y][x]=='.') {
						visited[y][x] = true;
						nhQueue.add(new int[] {y, x});
					}
					else if(matrix[y][x]=='D')
						return String.valueOf(cnt);
				}
			}
			if(nhQueue.isEmpty())
				return "KAKTUS";
			
			while(!wQueue.isEmpty()) {
				int[] node = wQueue.poll();
				for(int i=0; i<4; i++) {
					int y = node[0] + dy[i];
					int x = node[1] + dx[i];
					if(y<0 || y>=nrow || x<0 || x>=ncol)
						continue;
					if(matrix[y][x]=='.') {
						matrix[y][x] = '*';
						nwQueue.add(new int[] {y, x});
					}
				}
			}
			cnt++;
			hQueue = nhQueue;
			wQueue = nwQueue;
			nhQueue = new ArrayDeque<int[]>();
			nwQueue = new ArrayDeque<int[]>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		nrow = Integer.parseInt(temp[0]);
		ncol = Integer.parseInt(temp[1]);
		matrix = new char[nrow][];
		visited = new boolean[nrow][ncol];
		for(int i=0; i<nrow; i++) {
			matrix[i] = br.readLine().toCharArray();
			for(int j=0; j<ncol; j++) {
				switch(matrix[i][j]) {
				case '*': wQueue.add(new int[] {i, j}); break;
				case 'S': 
					hQueue.add(new int[] {i, j});
					matrix[i][j] = '.';
					visited[i][j] = true; 
					break;
				}
			}
		}
		System.out.println(solution());
	}
}