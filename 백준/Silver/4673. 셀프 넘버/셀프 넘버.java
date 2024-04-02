import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] v = new boolean[10001];

    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() {
        for (int i = 1; i < v.length; i++) {
            if (!v[i]) {
                System.out.println(i);
                deleteNum(i);
            }
        }
    }

    public static void deleteNum(int cur) {
        int now = cur;

        while (true) {
            if (now > 10000 || v[now]) {
                break;
            }
            v[now] = true;

            String strNow = Integer.toString(now);
            char[] charNow = strNow.toCharArray();

            int nextNow = 0;
            nextNow += now;
            
            for (char output : charNow) {
                nextNow += output - '0';
            }

            now = nextNow;
        }

    }
}
