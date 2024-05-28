import java.io.*;
import java.util.*;

public class Main {
    static String word;
    static boolean[][][] v;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        word = st.nextToken();
        int size = word.length();

        v = new boolean[size + 1][size + 1][size + 1];
    }

    private static void run() {
        int size = word.length();
        for (int a = 1; a <= size; a++) {
            for (int b = 1; b <= size - a; b++) {
                int c = size - a - b;
                if (c > 0) {
                    logic(a, b, c);
                }
            }
        }
        System.out.println(pq.poll());
    }

    private static void logic(int a, int b, int c) {
        if (v[a][b][c]) return;
        v[a][b][c] = true;

        StringBuilder sb = new StringBuilder();
        // 1번
        sb.append(new StringBuilder(word.substring(0, a)).reverse());
        // 2번
        sb.append(new StringBuilder(word.substring(a, a + b)).reverse());
        // 3번
        sb.append(new StringBuilder(word.substring(a + b, a + b + c)).reverse());

        pq.add(sb.toString());
    }
}
