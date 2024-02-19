
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, M, N, K;
    static int[][] map;
    static boolean[][] v;
    static int[] dictx = {-1, 1, 0, 0};
    static int[] dicty = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (T-- > 0) {
            answer = 0;
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            // 세로 N 가로 M
            map = new int[N + 2][M + 2];
            v = new boolean[N + 2][M + 2];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[Y + 1][X + 1] = 1;
                v[Y + 1][X + 1] = true;
            }
//            for (int x = 0; x <= N; x++) {
//                for (int y = 0; y <= N; y++) {
//                    System.out.print(map[x][y] + " ");
//                }
//                System.out.println();
//            }
//            for (int x = 0; x <= N; x++) {
//                for (int y = 0; y <= N; y++) {
//                    System.out.print(v[x][y] + " ");
//                }
//                System.out.println();
//            }
            bfs();
            sb.append(answer).append("\n");
//            System.out.println(answer);
        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<int[]>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                // 방문해야 하는 곳
                if (v[i][j]) {
                    if (map[i][j] == 1) {
//                        System.out.println("count ++ ");
                        q.add(new int[]{i, j});
                        v[i][j] = false;
                        answer++;
                        // 상하좌우 체크
                        while (!q.isEmpty()) {
                            int[] check = q.poll();
                            int X = check[0];
                            int Y = check[1];
                            // 상하좌우 확인
                            for (int idx = 0; idx < 4; idx++) {
                                if (map[X + dictx[idx]][Y + dicty[idx]] == 1 && v[X + dictx[idx]][Y + dicty[idx]]) {
//                                    System.out.println((X + dictx[idx]) + " " + (Y + dicty[idx]));
                                    q.add(new int[]{X + dictx[idx], Y + dicty[idx]});
                                    v[X + dictx[idx]][Y + dicty[idx]] = false;
                                }
                            }
                        }
                    }

                }


            }
        }
    }

}