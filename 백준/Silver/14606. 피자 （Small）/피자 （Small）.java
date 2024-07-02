import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 3;

        for(int i = 4; i <= 10 ; i++){
            if(i % 2 == 0){
                dp[i] = dp[i/2] * 2 + (i/2)*(i/2);
            }else{
                dp[i] = dp[i/2] + dp[i/2 + 1] + (i/2)*(i/2 + 1);
            }
        }
        System.out.println(dp[n]);
    }
}