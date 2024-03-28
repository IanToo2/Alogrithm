import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<int[]> list;
	static char[][] matrix;
	static int n;
	
	public static void solution() {
		rec(0);
	}
	
	public static boolean rec(int step) {
		if(step==list.size())
			return true;
		int[] point = list.get(step);
		int i = point[0];
		int j = point[1];
		int seq = getAvailable(i,j);
		if(seq == 1022)
			return false;
		for(int k=1; k<=n; k++) {
			if((seq&(1<<k)) != 0)
				continue;
			matrix[i][j] = (char)(k+'0');
			if(rec(step+1))
				return true;
			else
				matrix[i][j] = '0';
		}
		return false;
	}
	
	public static int getAvailable(int i, int j) {
		int seq = 0;
		for(int k=0; k<n; k++) {
			if(matrix[k][j] != '0')
				seq |= (1 << matrix[k][j]-'0');
			if(matrix[i][k] != '0')
				seq |= (1 << matrix[i][k]-'0');
		}
		for(int k=0; k<3; k++) {
			for(int l=0; l<3; l++)
				if(matrix[i/3*3+k][j/3*3+l] != '0')
					seq |= (1 << matrix[i/3*3+k][j/3*3+l]-'0');
		}
		return seq;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=9;
		matrix = new char[n][];
		list = new ArrayList<int[]>();
		for(int i=0; i<9; i++)
			matrix[i] = br.readLine().replace(" ", "").toCharArray();
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(matrix[i][j] == '0')
					list.add(new int[]{i,j});
		solution();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				sb.append(matrix[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}