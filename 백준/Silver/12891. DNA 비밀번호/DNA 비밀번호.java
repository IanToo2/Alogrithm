import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int s, p, answer;
    static int checknum[] = new int[4];
    static char[] data;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        data = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checknum[i] = Integer.parseInt(st.nextToken());
//            System.out.print(checknum[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        logic();
        System.out.print(answer);
    }

    public static void logic() {
        int end = p - 1;
        int[] cur = new int[4];

        for (int i = 0; i <= end; i++) {
            if (data[i] == 'A') {
                cur[0]++;
            } else if (data[i] == 'C') {
                cur[1]++;
            } else if (data[i] == 'G') {
                cur[2]++;
            } else if (data[i] == 'T') {
                cur[3]++;
            }
        }
//        System.out.println("\n------------------------");
//        for(int a : cur){
//            System.out.print(a + " ");
//        }
        if(checkNum(cur)){
            answer++;
        }

        for(int i = 0 ; i < s-p ; i++){
            char minus = data[i];
            char plus = data[i+p];
            if(minus == 'A'){
                cur[0]--;
            }else if (minus == 'C'){
                cur[1]--;
            }else if (minus == 'G'){
                cur[2]--;
            }else if (minus == 'T'){
                cur[3]--;
            }

            if(plus == 'A'){
                cur[0]++;
            }else if (plus == 'C'){
                cur[1]++;
            }else if (plus == 'G'){
                cur[2]++;
            }else if (plus == 'T'){
                cur[3]++;
            }
//            System.out.println("\n------------------------");
//            for(int a : cur){
//                System.out.print(a + " ");
//            }
            if(checkNum(cur)){
                answer ++;
            }
        }

    }
    public static boolean checkNum(int[] cur){
        for (int i = 0; i < 4; i++) {
            if(cur[i] < checknum[i]){
                return false;
            }
        }
        return true;
    }
}