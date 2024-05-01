import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[] input;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            run();
        }
        System.out.print(sb);
    }

    private static void init() throws Exception {
        input = br.readLine().toCharArray();
    }

    private static void run() {
        int lastIdx = input.length - 1;
        int top = lastIdx;
        
        while (top > 0 && input[top - 1] >= input[top]) {
            top--;
        }

        if (top > 0) {
            int cur = lastIdx;
            while (input[top - 1] >= input[cur]) {
                cur--;
            }

            swap(input, top - 1, cur);

            while (top < lastIdx) {
                swap(input, top, lastIdx);
                top++;
                lastIdx--;
            }
        }

        for (char output : input) {
            sb.append(output);
        }
        sb.append("\n");
    }

    private static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
