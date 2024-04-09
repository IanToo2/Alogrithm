import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] v;
    static boolean[][] copy;
    static List<int[]> cctv = new ArrayList<>();
    static List<int[]> data = new ArrayList<>();
    static int[] now;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    v[i][j] = true;
                }
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new int[]{i, j, map[i][j]});
                }
            }
        }
    }

    private static void run() {
        // 경우의 수 뽑기
        now = new int[cctv.size()];
        recur(0);
        // 케이스 마다 최소! 사각 지대 크기 찾기
        for (int[] output : data) {
            // v copy
            copyV();
            // cctv 방향 설정
            for (int i = 0; i < cctv.size(); i++) {
                // num 1 cctv
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                int cctvType = cctv.get(i)[2];
                int dict = output[i];
                if (cctvType == 1) {
                    eraseOne(dict, x, y);
                } else if (cctv.get(i)[2] == 2) {
                    eraseTwo(dict, x, y);
                } else if (cctv.get(i)[2] == 3) {
                    eraseThree(dict, x, y);
                } else if (cctv.get(i)[2] == 4) {
                    eraseFour(dict, x, y);
                } else if (cctv.get(i)[2] == 5) {
                    eraseAll(dict, x, y);
                }
            }

//            printCopy();
            findAnswer();
        }
        System.out.println(answer);
    }
    private static void findAnswer(){
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(!copy[i][j]) cnt++;
                if(cnt > answer){
                    return;
                }
            }
        }
        if(cnt < answer){
//            System.out.println("find answer");
            answer = cnt;
        }
    }
    private static void eraseAll(int dict, int x, int y) {
        // 상
        for (int i = x; i >= 0; i--) {
            if(map[i][y] == 6) break;
            copy[i][y] = true;
        }
        // 하
        for (int i = x; i < n; i++) {
            if(map[i][y] == 6) break;
            copy[i][y] = true;
        }
        // 좌
        for (int i = y; i >= 0; i--) {
            if(map[x][i] == 6) break;
            copy[x][i] = true;
        }
        // 우
        for (int i = y; i < m; i++) {
            if(map[x][i] == 6) break;
            copy[x][i] = true;
        }
    }

    private static void eraseOne(int dict, int x, int y) {
        while (true) {
            if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 6) {
                break;
            }
            copy[x][y] = true;
            x += dx[dict];
            y += dy[dict];
        }
    }

    private static void eraseTwo(int dict, int x, int y) {
        if (dict == 0) {
            // 좌
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
            // 우
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else {
            // 상
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 하
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
        }
    }

    private static void eraseThree(int dict, int x, int y) {
        if (dict == 0) {
            //  상, 우
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else if (dict == 1) {
            // 우 하
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
        } else if (dict == 2) {
            // 하 좌
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else {
            // 좌 상
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
        }
    }

    private static void eraseFour(int dict, int x, int y) {
        if (dict == 0) {
            // 하 제외
            // 상
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 좌
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
            // 우
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else if (dict == 1) {
            // 좌 제외
            // 상
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 하
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }

            // 우
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else if (dict == 2) {
            // 상 제외

            // 하
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 좌
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
            // 우
            for (int i = y; i < m; i++) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }
        } else {
            // 우 제외
            // 상
            for (int i = x; i >= 0; i--) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 하
            for (int i = x; i < n; i++) {
                if(map[i][y] == 6) break;
                copy[i][y] = true;
            }
            // 좌
            for (int i = y; i >= 0; i--) {
                if(map[x][i] == 6) break;
                copy[x][i] = true;
            }

        }
    }

    private static void recur(int depth) {
        if (depth == cctv.size()) {
            data.add(now.clone());
            return;
        }
        if (cctv.get(depth)[2] == 1 || cctv.get(depth)[2] == 3 || cctv.get(depth)[2] == 4) {
            for (int i = 0; i < 4; i++) {
                now[depth] = i;
                recur(depth + 1);
            }
        } else if (cctv.get(depth)[2] == 2) {
            for (int i = 0; i < 2; i++) {
                now[depth] = i;
                recur(depth + 1);
            }
        } else {
            now[depth] = 5;
            recur(depth + 1);
        }
    }

    private static void copyV() {
        copy = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = v[i].clone();
        }
    }

    private static void printV() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printCopy() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
    }
}
