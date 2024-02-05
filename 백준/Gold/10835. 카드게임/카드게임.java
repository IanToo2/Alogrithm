import java.io.*;
import java.util.*;

class Main {
    static int strToInt(String s) { return Integer.parseInt(s);}

    static int n;
    static int[] left;
    static int[] right;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = strToInt(br.readLine());
        left = new int[n];
        right = new int[n];
        dp = new int[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            left[i] = strToInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            right[i] = strToInt(st.nextToken());

        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static int recur(int l, int r) {
        if(l == n || r == n)
            return 0;

        if(dp[l][r] != -1)
            return dp[l][r];

        dp[l][r] = Math.max(recur(l+1, r+1), recur(l+1, r));

        if(left[l] > right[r])
            dp[l][r] = Math.max(dp[l][r], recur(l, r+1) + right[r]);

        return dp[l][r];
    }
}