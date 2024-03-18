import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] keep = new int[9];
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {

        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            int needNum = input[i] - '0';
            if(needNum == 9){
                needNum = 6;
            }
//            System.out.println(needNum);
            if (keep[needNum] == 0) {
                buy();

            }
            keep[needNum]--;

        }

        System.out.println(cnt);
    }

    public static void buy() {
        cnt++;
        for (int i = 0; i < 9; i++) {
            keep[i]++;
        }
        // 6 == 9
        keep[6]++;
    }
}