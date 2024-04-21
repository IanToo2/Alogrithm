import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b, n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;
    static Robot[] robot;

    static class Robot {
        int x;
        int y;
        int dict;

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dict='" + dict + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[b][a];

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        robot = new Robot[n];
        m = Integer.parseInt(st.nextToken());
        // 로봇 입력받기
        for (int i = 0; i < n; i++) {
            robot[i] = new Robot();
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = b - Integer.parseInt(st.nextToken());

            robot[i].x = x;
            robot[i].y = y;
            String dict = st.nextToken();
            if (dict.equals("N")) {
                robot[i].dict = 0;
            } else if (dict.equals("E")) {
                robot[i].dict = 1;
            } else if (dict.equals("S")) {
                robot[i].dict = 2;
            } else {
                robot[i].dict = 3;
            }
            map[x][y] = i;
        }
    }

    private static void run() throws Exception {
        // m개의 명령 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 로봇
            int cur = Integer.parseInt(st.nextToken()) - 1;
            // 내리는 명령
            String order = st.nextToken();
            // 횟수
            int cnt = Integer.parseInt(st.nextToken());
            if (!order(cur, order, cnt)) {
                return;
            }
//            checkRobot();
        }
        System.out.println("OK");
    }

    private static boolean order(int cur, String order, int cnt) {
        // 회전하기
        if (order.equals("L") || order.equals("R")) {
            // 왼쪽으로 회전
            if (order.equals("L")) {
                cnt = cnt % 4;
                for (int i = 0; i < cnt; i++) {
                    robot[cur].dict -= 1;
                    if (robot[cur].dict == -1) {
                        robot[cur].dict = 3;
                    }
                }
            }
            // 오른쪽으로 회전
            else {
                robot[cur].dict += cnt;
                robot[cur].dict = robot[cur].dict % 4;
            }

        }
        // 전진하기
        else {
            for (int i = 0; i < cnt; i++) {
//                System.out.println(i);
                int nx = robot[cur].x + dx[robot[cur].dict];
                int ny = robot[cur].y + dy[robot[cur].dict];

                // 맵 밖으로 나가는 경우
                if (nx < 0 || ny < 0 || nx >= b || ny >= a) {
                    System.out.println("Robot " + (cur + 1) + " crashes into the wall");
                    return false;
                }
                // 로봇과 부딪히는 경우
                if (map[nx][ny] != 0) {
                    System.out.println("Robot " + (cur + 1) + " crashes into robot " + (map[nx][ny]+1));
                    return false;
                }

                // 정상적으로 움직이는 경우
                map[robot[cur].x][robot[cur].y] = 0;
                map[nx][ny] = cur;
                robot[cur].x = nx;
                robot[cur].y = ny;
//                checkRobot();
            }
        }
        return true;
    }

    private static void checkRobot() {
        for (int i = 0; i < n; i++) {
            System.out.println(robot[i].toString());
        }
    }
}
