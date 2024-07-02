import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100_001];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i <= n; i++){
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
//                System.out.println("case 1");
                dp[i] = -1;
            }else if (dp[i-2] == -1){
//                System.out.println("case 2");
                dp[i] = dp[i-5] + 1;
            }else if( dp[i-5] == -1){
//                System.out.println("case 3");
                dp[i] = dp[i-2] + 1;
            }else{
//                System.out.println("case 4");
                dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
            }
//            System.out.println(i + " : " +dp[i]);
        }

        System.out.println(dp[n]);
    }
}