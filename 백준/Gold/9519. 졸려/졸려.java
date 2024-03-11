import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // -----------------------------------------------------------------------------------//
    static int cycle;
    static long X;
    static String input, answer, test;
    static Deque<String> q1 = new LinkedList<>();
    static Deque<String> q2 = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        init();
        findCycle();
//        System.out.println(cycle - (X%cycle) + " 번 돌리자?");
//        System.out.println(q1.size());
//        System.out.println(q2.size());

        for (int i = 1; i <= cycle - (X%cycle); i++) {
//            System.out.println((i)+"번");
            if (q2.isEmpty()) {
                while (true) {
                    String output1 = q1.pollLast();
                    q2.add(output1);
                    if (q1.isEmpty()) {
                        break;
                    }
                    String output2 = q1.pollFirst();
                    q2.add(output2);
                    if (q1.isEmpty()) {
                        break;
                    }
                }
            } else {
                while (true) {
                    String output1 = q2.pollLast();
                    q1.add(output1);
                    if (q2.isEmpty()) {
                        break;
                    }

                    String output2 = q2.pollFirst();
                    q1.add(output2);
                    if (q2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        print();
    }

    public static void init() throws Exception {
        X = Long.parseLong(br.readLine());
        input = br.readLine();
        test = input.substring(1);
//        System.out.println(test);
        int inputSize = input.length();

        if (X == 0) {
            return;
        }


    }

    public static void findCycle() {
        String result = "";
        for (String output : input.split("")) {
            q1.add(output);
        }
        answer = "" + q1.pollFirst();
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {

//            System.out.println((i+1)+"번");
            if (q2.isEmpty()) {
                while (true) {
                    String output1 = q1.pollLast();
                    result += output1;
                    q2.add(output1);
                    if (q1.isEmpty()) {
                        break;
                    }
                    String output2 = q1.pollFirst();
                    result += output2;
                    q2.add(output2);
                    if (q1.isEmpty()) {
                        break;
                    }
                }
            } else {
                while (true) {
                    String output1 = q2.pollLast();
                    q1.add(output1);
                    result += output1;
                    if (q2.isEmpty()) {
                        break;
                    }

                    String output2 = q2.pollFirst();
                    result += output2;
                    q1.add(output2);
                    if (q2.isEmpty()) {
                        break;
                    }
                }
            }
//            System.out.println(i + "번 : " + result);

            if (result.equals(test)) {
//                System.out.println("test = " + test);
//                System.out.println("result = " + result);
//                System.out.println("Cycle = " + i);
                cycle = i;
                break;
            }
            result = "";
        }

    }

    public static void print() {
        System.out.print(answer);
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                System.out.print(q1.pollFirst());
            }
        } else {
            while (!q2.isEmpty()) {
                System.out.print(q2.pollFirst());
            }
        }
    }
}
