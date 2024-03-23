import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    ////////////////////////////////////////////////////////////////////////////////////////
    static int t;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        t = Integer.parseInt(br.readLine());
        run();
        System.out.println(sb);
    }

    public static void run() throws Exception {

        while (t-- > 0) {
            int x = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while (a != 1) {
                x = (b % a == 0) ? (b / a) : (b / a + 1);
                a = a * x - b;
                b *= x;
                int g = gcd(a, b);
                a /= g;
                b /= g;
            }
            sb.append(b).append("\n");
//            System.out.println(b);
        }


    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}