import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine()); // 개수
		
        long Lcnt = 0;
        long Rcnt = 0;
        long sum = 0;
        int idx = 0;
		
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
			
            if (num % 2 == 0) {
                sum += idx++;
                Lcnt += i;
                Rcnt += N - 1 - i;
            }
        }
        
        System.out.println(Math.min(Lcnt, Rcnt) - sum);
    }
}