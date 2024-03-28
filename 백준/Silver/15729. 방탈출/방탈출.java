import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    //
    static Deque<Integer> answer = new ArrayDeque<>();
    static Deque<Integer> input = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    public static void init() throws Exception {
        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            answer.add(Integer.parseInt(st.nextToken()));
            input.add(0);
        }
    }

    public static void run() {
        int cnt = 0;
        int roateCnt = answer.size();
        for (int i = 0; i < roateCnt; i++) {
            int answerData = answer.poll();
            int inputData = input.poll();
//            System.out.println("cnt : " + cnt);
//            System.out.println("answerData : " + answerData);
//            System.out.println("inputData : " + inputData);
            if ((inputData == answerData)) {
                continue;
            }
            cnt++;
            if (i < roateCnt - 2) {
                int next1 = input.poll();
                if (next1 == 0) {
                    next1 = 1;
                } else if (next1 == 1) {
                    next1 = 0;
                }
                int next2 = input.poll();
                if (next2 == 0) {
                    next2 = 1;
                } else if (next2 == 1) {
                    next2 = 0;
                }

                input.addFirst(next2);
                input.addFirst(next1);
            }
            else if ( i < roateCnt-1){
                int next1 = input.poll();
                if (next1 == 0) {
                    next1 = 1;
                } else if (next1 == 1) {
                    next1 = 0;
                }
                input.addFirst(next1);
            }

        }
        System.out.println(cnt);
    }
}
