import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[10_001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            data[idx]++;
        }

        for(int i = 1; i < 10_001; i++){
            int time = data[i];
            if(time != 0) {
                while (time-- > 0) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
