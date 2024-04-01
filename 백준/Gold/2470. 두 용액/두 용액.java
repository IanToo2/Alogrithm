import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] data;
    static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        data = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        answer[2] = Integer.MAX_VALUE;
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));
    }

    public static void run() {
        int start = 0;
        int end = n - 1;
        if (data[start] > 0 && data[end] > 0) {
            System.out.println(data[0] + " " + data[1]);
        } else if (data[start] < 0 && data[end] < 0) {
            System.out.println(data[end - 1] + " " + data[end]);
        } else {
            while (true) {
                int nowState = data[end] + data[start];
//            System.out.println("now start, end : " + start + "," + end);
//            System.out.println("nowState : " + nowState);
                if (answer[2] > Math.abs(nowState)) {
                    answer[0] = start;
                    answer[1] = end;
                    answer[2] = Math.abs(nowState);
                }
                if (nowState == 0 || Math.abs(end - start) == 1) {
                    break;
                } else if (nowState > 0) {
                    end--;
                } else {
                    start++;
                }

            }
            System.out.println(data[answer[0]] + " " + data[answer[1]]);
//        System.out.println(answer[2]);
        }
    }
}
