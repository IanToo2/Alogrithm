import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] matrix;
	static class Coor {
		int y;
		int x;
		public Coor(int y, int x)
		{ 
			this.y = y; 
			this.x = x;
		}
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static int solution(int n) {
		int[][] result = new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(result[i], Integer.MAX_VALUE/2);
		result[0][0] = matrix[0][0];
		Queue<int[]> queue = new ArrayDeque();
		queue.add(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int[] coor = queue.poll();
			for(int i=0; i<4; i++) {
				int y = coor[0] + dy[i];
				int x = coor[1] + dx[i];
				if(x<0 ||x>=n || y<0 || y>=n)
					continue;
				if(result[y][x] > result[coor[0]][coor[1]]+matrix[y][x]) {
					result[y][x] = result[coor[0]][coor[1]]+matrix[y][x];
					queue.add(new int[] {y, x});
				}
			}
		}
		return result[n-1][n-1];
	}
	
	public static void main(String[] args) throws IOException {
		int cnt = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			matrix = new int[n][n];
			for(int i=0; i<n; i++)
				matrix[i] = convert(br.readLine().split(" "));
			bw.append("Problem "+cnt+": "+solution(n)+"\n");
			cnt++;
		}
		bw.flush();
	}
}