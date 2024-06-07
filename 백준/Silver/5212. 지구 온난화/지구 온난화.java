import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C]; // 지도 입력
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        int minR = 10, minC = 10;
        int maxR = 0, maxC = 0;

        char[][] after = new char[R][C]; // 50년 후
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') { // 땅인 경우
                    int cnt = 0; // 주변 바다 수
                    for (int k = 0; k < 4; k++) { // 4방향 탐색
                        int x = i + di[k];
                        int y = j + dj[k];

                        // 지도 밖인 경우에는 바다
                        if ((x == -1 || y == -1 || x == R || y == C) || map[x][y] == '.') {
                            cnt++;
                        }
                    }

                    if (cnt < 3) { // 3면 이하가 바다인 경우
                        after[i][j] = 'X';

                        minR = Math.min(minR, i); // 지도 출력 범위 갱신
                        minC = Math.min(minC, j);
                        maxR = Math.max(maxR, i);
                        maxC = Math.max(maxC, j);
                    } else {
                        after[i][j] = '.';
                    }
                } else {
                    after[i][j] = '.';
                }
            }
        }

        StringBuilder answer = new StringBuilder(); // 출력
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                answer.append(after[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}