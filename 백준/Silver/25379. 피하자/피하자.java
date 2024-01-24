import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] data = new boolean[t];

        int leftCnt = 0;
        int rightCnt = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < t; i++) {
            // 짝수인지 판별
            if ((Integer.parseInt(st.nextToken()) % 2) == 0) {
                data[i] = true;
                leftCnt += i;
                rightCnt += t-1-i;
                sum += cnt;
                cnt +=1;
            }
        }
        if ( leftCnt < rightCnt){
            System.out.println(leftCnt-sum);
        }else{
            System.out.println(rightCnt-sum);
        }
    }
}

