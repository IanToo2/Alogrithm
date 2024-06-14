import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String answer = logic(n, m);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static String logic(int n, int m) {
        String change = Integer.toBinaryString(m);
        if(change.length() < n){
            return "OFF";
        }
        for (int i = change.length() - 1; i >= change.length() - n; i--) {
            if(change.charAt(i) != '1'){
                return "OFF";
            }
        }
        return "ON";
    }
}
