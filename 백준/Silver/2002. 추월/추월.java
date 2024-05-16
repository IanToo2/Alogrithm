import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int[] arr;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		init();
		run();
	}

	private static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
        

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr[i] = map.get(input);
        }

	}

	private static void run() {
		int answer = 0;
		
		for(int i = 0; i< n-1; i++){
            for(int j = i+1; j< n; j++){
                if(arr[i] > arr[j]){
                    answer += 1;
                    break;
                }
            }
        }
		System.out.print(answer);
	}
}