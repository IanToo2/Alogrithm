import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    //
    static int T, n, teamSize, answer;
    static int[] teamA, teamB;
    static boolean[] v;


    static int[][] map;

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(sb);
    }

    public static void init() throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            teamSize = n / 2;
            teamA = new int[teamSize];
            teamB = new int[teamSize];
            v = new boolean[n];
            answer = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            run();
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
    }

    public static void run() {
        recur(0);
    }

    public static void recur(int depth) {
        if (depth == teamSize) {
//            System.out.println(Arrays.toString(teamA));
            int depthTeamB = 0;
            for (int i = 0; i < n; i++) {
                if (v[i]) continue;

                teamB[depthTeamB] = i;
                depthTeamB++;
            }
//            System.out.println(Arrays.toString(teamB));
//            System.out.println();
            checkValue();
            return;
        }

        if (depth == 0) {
            for (int i = 0; i < n; i++) {
                if (v[i]) continue;

                teamA[depth] = i;
                v[i] = true;
                recur(depth + 1);
                v[i] = false;
            }
        } else {
            for (int i = teamA[depth - 1]; i < n; i++) {
                if (v[i]) continue;

                teamA[depth] = i;
                v[i] = true;
                recur(depth + 1);
                v[i] = false;
            }
        }
    }

    public static void checkValue() {
        int scoreTeamA = 0;
        int scoreTeamB = 0;
        for (int i = 0; i < teamSize - 1; i++) {
            for (int j = i+1; j < teamSize; j++) {
                scoreTeamA += map[teamA[i]][teamA[j]] + map[teamA[j]][teamA[i]];
            }
        }
        for (int i = 0; i < teamSize - 1; i++) {
            for (int j = i+1; j < teamSize; j++) {
                scoreTeamB += map[teamB[i]][teamB[j]] + map[teamB[j]][teamB[i]];
            }
        }
        if(Math.abs(scoreTeamA-scoreTeamB) < answer){
            answer = Math.abs(scoreTeamA-scoreTeamB);
        }
//        System.out.println(Math.abs(scoreTeamA-scoreTeamB));
    }
}
