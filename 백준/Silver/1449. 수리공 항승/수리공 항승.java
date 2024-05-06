import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken()) * 10;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            pq.add(Integer.parseInt(st.nextToken()) * 10 );
        }
    }

    private static void run() {
        boolean[] v = new boolean[10006];
        int cnt = 0;
        while (!pq.isEmpty()) {
            // 테이프 필요한지 확인
            int cur = pq.poll();
//            System.out.println("Target : " + cur);
            if (check(cur, v)) continue;
//            System.out.println("Need Fix : " + (cur - 5) + " ~ " + (cur - 5 + len));
            for (int i = cur - 5; i <= cur - 5 + len; i++) {
                if (i == 10005) {
                    break;
                }
                v[i] = true;
            }
            cnt++;
        }
//        map(v);
        System.out.print(cnt);
    }

    private static boolean check(int cur, boolean[] v) {
        for(int i = cur - 5 ; i <= cur + 5; i++){
            if(i==10005){
                break;
            }
            if(!v[i]){
                return false;
            }
        }
        return true;
    }
    private static void map(boolean[] v){
        for(boolean output : v){
            if(output){
                System.out.print(1 +" ");
            }else{
                System.out.print(0 + " ");
            }
        }
    }

}
