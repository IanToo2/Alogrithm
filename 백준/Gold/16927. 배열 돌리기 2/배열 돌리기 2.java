import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R;
    static int map[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        logic();
        print();
    }

    public static void logic() {
        int nowCycle = 2 * (N + M) - 4;
        int start = 0;
        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            int nowR = R % nowCycle;
            for (int j = 0; j < nowR; j++) {
                int temp = map[start][start];
                int idx = 0;
                int x = start;
                int y = start;

                while (true) {
                    if (idx == 4) {
                        break;
                    }
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if (nx >= start && ny >= start && nx < N - start && ny < M - start) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        idx++;
                    }
                }
                map[start+1][start] = temp;
            }
            nowCycle -= 8;
            start++;
        }

    }
    public static void print(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < M ; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}