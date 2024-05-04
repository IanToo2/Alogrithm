import java.io.*;
import java.util.*;

public class Solution {
    static int[] now;
    static int[] cnt;
    static int[] data = {3, 6, 9};
    static int n;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = new int[1001];
    }

    private static void run() {
        for (int i = 1; i <= 3; i++) {
            now = new int[i];
            recur(0, 0);
        }

//        System.out.println(Arrays.toString(cnt));

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                System.out.print(i + " ");
            } else {
                for (int j = 0; j < cnt[i]; j++) {
                    System.out.print('-');
                }
                System.out.print(' ');
            }
        }
    }

    private static void recur(int depth, int count) {
        if (depth == now.length) {
//            System.out.println(Arrays.toString(now));
            int value = 0;
            for (int i = 0; i < now.length; i++) {
                value += now[i] * (int) Math.pow(10, now.length - 1 - i);
            }
//            System.out.println(value);
            cnt[value] += count;
            return;
        }

        if (depth == 0) {
            for (int i = 1; i <= 9; i++) {
                if (i == 3 || i == 6 || i == 9) {
                    now[depth] = i;
                    recur(depth + 1, count + 1);
                } else {
                    now[depth] = i;
                    recur(depth + 1, count);
                }
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (i == 3 || i == 6 || i == 9) {
                    now[depth] = i;
                    recur(depth + 1, count + 1);
                } else {
                    now[depth] = i;
                    recur(depth + 1, count);
                }
            }
        }
    }
}
