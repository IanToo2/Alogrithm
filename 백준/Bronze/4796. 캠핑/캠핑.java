import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            // 종료 조건 수정
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int answer = (V / P) * L + Math.min(V % P, L);
            System.out.println("Case " + t + ": " + answer);
            t += 1;
        }
    }
}
