import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[] order;
    static int minX;
    static int minY;
    static int maxX;
    static int maxY;

    static Turtle turtle;

    static class Turtle {
        int x = 0;
        int y = 0;
        int dict = 0;
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            run();
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        order = br.readLine().toCharArray();
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
    }

    private static void run() {
        turtle = new Turtle();
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 'F') {
                front();
            } else if (order[i] == 'B') {
                back();
            }
            // 왼쪽
            else if (order[i] == 'L') {
                turtle.dict--;
                if (turtle.dict == -1) {
                    turtle.dict = 3;
                }
            }
            // 오른쪽
            else {
                turtle.dict = (turtle.dict + 1) % 4;
            }
            check();
        }

//        System.out.println(minX + " , " + minY);
//        System.out.println(maxX + " , " + maxY);

        sb.append(Math.abs(maxX-minX) * Math.abs(maxY-minY)).append("\n");
    }

    private static void front() {
        if (turtle.dict == 0) {
            turtle.y++;
        } else if (turtle.dict == 1) {
            turtle.x++;
        } else if (turtle.dict == 2) {
            turtle.y--;
        } else {
            turtle.x--;
        }
    }

    private static void back() {
        if (turtle.dict == 0) {
            turtle.y--;
        } else if (turtle.dict == 1) {
            turtle.x--;
        } else if (turtle.dict == 2) {
            turtle.y++;
        } else {
            turtle.x++;
        }
    }

    private static void check() {
        if (minX > turtle.x) {
            minX = turtle.x;
        }
        if (maxX < turtle.x) {
            maxX = turtle.x;
        }
        if (minY > turtle.y) {
            minY = turtle.y;
        }
        if (maxY < turtle.y) {
            maxY = turtle.y;
        }
    }
}
