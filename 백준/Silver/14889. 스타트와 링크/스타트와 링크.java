import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    //
    static int n, teamCnt;
    static int answer = Integer.MAX_VALUE;
    static int[] teamA, teamB;
    static boolean[] v;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        init();
        run();
//        System.out.println("Answer : " + answer);
        System.out.print(answer);
    }


    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void run() {
        teamCnt = n / 2;
        teamA = new int[teamCnt];
        teamB = new int[teamCnt];
        // team 뽑기
        recur(0);
    }

    public static void recur(int depth) {
        if (depth == teamCnt) {
            int teamBidx = 0;
            for (int i = 0; i < n; i++) {
                if (!v[i]) {
                    teamB[teamBidx] = i;
                    teamBidx++;
                    if (teamBidx == teamCnt) {
                        break;
                    }
                }
            }

//            System.out.println("A team : " + Arrays.toString(teamA));
//            System.out.println("B team : " + Arrays.toString(teamB));
//            System.out.println("now score gap : " + findScore());
            findScore();
//            System.out.println();
            return;
//            System.out.println(Arrays.toString(teamB));
        }

        for (int i = depth == 0 ? 0 : (teamA[depth - 1] + 1); i < n; i++) {
            //if (v[i]) {
            //
            //    continue;
            //}
            v[i] = true;
            teamA[depth] = i;
            recur(depth + 1);
            v[i] = false;
        }
    }

    public static int findScore() {
        int teamScoreA = 0;
        int teamScoreB = 0;

        // team a
        for (int i = 0; i < teamCnt-1; i++) {
            for (int j = i + 1; j < teamCnt; j++) {
                teamScoreA += map[teamA[i]][teamA[j]];
                teamScoreA += map[teamA[j]][teamA[i]];
            }
        }
        // team b
        for (int i = 0; i < teamCnt-1; i++) {
            for (int j = i + 1; j < teamCnt; j++) {
                teamScoreB += map[teamB[i]][teamB[j]];
                teamScoreB += map[teamB[j]][teamB[i]];
            }
        }
//        System.out.println("A team Score : " + teamScoreA);
//        System.out.println("B team Score : " + teamScoreB);
        int nowScore = Math.abs(teamScoreA - teamScoreB);
        if (nowScore < answer) {
            answer = nowScore;
        }
        return nowScore;
    }
}