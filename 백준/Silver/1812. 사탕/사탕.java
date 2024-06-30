import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 3 <= n <= 999 홀수
        // 사탕 0 ~ 100,000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] answer = new int[n];
        int start = 0;
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(br.readLine());
            if( i % 2 == 0){
                start += input[i];
            }else{
                start -= input[i];
            }
        }
        answer[0] = start / 2;
        sb.append(answer[0]).append("\n");
        
        for(int i = 1; i < n ; i++){
            answer[i] = input[i-1] - answer[i-1];
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
