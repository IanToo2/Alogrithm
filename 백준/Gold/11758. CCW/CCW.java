import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static List<int[]> data = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			data.add(new int[] { x, y });
		}
	}

	private static void run() {
		int result = ( data.get(0)[0]*data.get(1)[1] +data.get(1)[0]*data.get(2)[1] +data.get(2)[0]*data.get(0)[1] )
				- ( data.get(0)[1]*data.get(1)[0] + data.get(1)[1]*data.get(2)[0] + data.get(2)[1]*data.get(0)[0]);
		
		
		if(result < 0 ) {
			result = -1;
		}else if (result > 0 ) {
			result = 1;
		}
		
		System.out.println(result);
		

	}
}
