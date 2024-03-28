import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    //

    static int n;
    static PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1) == Math.abs(o2))
                return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        }
    });


    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        run(n);
    }

    public static void run(int cnt) throws Exception {
        while (cnt-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
//                    sb.append(q.poll()).append("\n");
                }

            } else {
                q.add(input);
            }
        }
        /*System.out.println(q);*/
    }
}
