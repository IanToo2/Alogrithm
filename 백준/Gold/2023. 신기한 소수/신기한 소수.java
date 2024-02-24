import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        init();
        logic(0, "");
        System.out.print(sb);
    }

    public static void logic(int depth, String cur) {
        if (depth == N) {
            sb.append(cur).append("\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            if(i == 1 && depth == 0){
                continue;
            }
            String now = cur + i;
            if (isPrime(Integer.parseInt(now))) {
                logic(depth + 1, now);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}