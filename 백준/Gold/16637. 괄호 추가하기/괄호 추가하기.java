import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num.add(input.charAt(i)-'0');
            }else{
                op.add(input.charAt(i));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, num.get(0));
        System.out.print(answer);
    }

    public static void dfs(int idx, int sum) {
        if (idx == op.size()) {
            answer = Math.max(answer, sum);
            return;
        }
    
        dfs(idx + 1, calculate(sum, num.get(idx + 1), op.get(idx)));

        if (idx + 2 <= op.size()) {
            dfs(idx + 2, calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx)));
        }
    }
    public static int calculate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}