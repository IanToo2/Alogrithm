import java.io.*;
import java.util.*;

public class Main {
    static int size = 0;
    static Map<Character, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        size = input.length;
        for (int i = 0; i < size; i++) {
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }
        }
    }

    private static void run() {
//        map.entrySet().forEach(System.out::println);
        int idx = 0;
        char[] answer = new char[size / 2];
        char pivot = ' ';
        boolean check = true;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (check && e.getValue() % 2 == 1) {
                pivot = e.getKey();
                check = false;
            } else if (!check && e.getValue() % 2 == 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            for (int i = idx; i < idx + (e.getValue() / 2); i++) {
                answer[i] = e.getKey();
            }
            idx += e.getValue() / 2;
        }


        if (size % 2 == 0) {
            for (char output : answer) {
                System.out.print(output);
            }

            for (int i = size / 2 - 1; i >= 0; i--) {
                System.out.print(answer[i]);
            }
        } else {
            for (char output : answer) {
                System.out.print(output);
            }
            if (pivot != ' ') {
                System.out.print(pivot);
            }
            for (int i = size / 2 - 1; i >= 0; i--) {
                System.out.print(answer[i]);
            }
        }
    }
}
