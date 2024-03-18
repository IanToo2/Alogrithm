
import java.io.*;
import java.util.*;

public class Main {
    static class coin {
        int x;
        int y;

        coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static int N, M;
    static coin coin1 = null;
    static coin coin2 = null;
    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] inputData = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = inputData[j];
                if (map[i][j] == 'o') {
                    if (coin1 == null) {
                        coin1 = new coin(i, j);
                    } else {
                        coin2 = new coin(i, j);
                    }
                }
            }
        }

    }
    public static void run(){
        int answer = bfs(coin1, coin2);
        System.out.println(answer);
    }
    public static int bfs(coin coin1, coin coin2) {
        Queue<coin[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        q.add(new coin[]{coin1, coin2});
        String start = "";
        start += coin1.x;
        start += coin1.y;
        start += coin2.x;
        start += coin2.x;
        start += coin2.y;
        visited.add(start);

        int depth = 1;

        while (!q.isEmpty()) {
            if (depth > 10) return -1;
            int len = q.size();
            for (int l = 0; l < len; l++) {
                coin[] now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx1 = now[0].x + dist[i][0];
                    int ny1 = now[0].y + dist[i][1];

                    int nx2 = now[1].x + dist[i][0];
                    int ny2 = now[1].y + dist[i][1];

                    if ((!check(nx1, ny1) && check(nx2, ny2)) || (check(nx1, ny1) && !check(nx2, ny2))) {
                        return depth;
                    }
                    if ((!check(nx1, ny1) && !check(nx2, ny2))) continue;

                    if (map[nx1][ny1] == '#' && map[nx2][ny2] == '#') continue;

                    if (map[nx1][ny1] == '#' && map[nx2][ny2] != '#') {
                        if (now[0].x == nx2 && now[0].y == ny2) continue;
                        nx1 = now[0].x;
                        ny1 = now[0].y;
                    } else if (map[nx1][ny1] != '#' && map[nx2][ny2] == '#') {
                        if (now[1].x == nx1 && now[1].y == ny1) continue;
                        nx2 = now[1].x;
                        ny2 = now[1].y;
                    }
                    String next = "";
                    next += nx1;
                    next += ny1;
                    next += nx2;
                    next += ny2;

                    if (visited.contains(next)) continue;

                    visited.add(next);
                    q.add(new coin[]{new coin(nx1, ny1), new coin(nx2, ny2)});
                }
            }
            depth++;
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}