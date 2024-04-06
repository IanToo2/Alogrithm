import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer;
    static int[] cost;
    static int[] month;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            init();
            run();
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception {
        answer = Integer.MAX_VALUE;
        cost = new int[4];
        month = new int[12];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 12; i++) {
            month[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void run() {
        recur(0, 0);
    }

    private static void recur(int depth, int sum) {
//        System.out.println(depth+"월 비욜 : " + sum);
        if(sum > answer){
            return;
        }

        if (depth >= 12) {
            if(answer > sum){
            answer = sum;}
            return;
        }

        // day
        recur(depth + 1, sum + cost[0] * month[depth]);
        // month
        recur(depth + 1, sum + cost[1]);
        recur(depth + 3, sum + cost[2]);
        recur(depth + 12, sum + cost[3]);
    }
}
