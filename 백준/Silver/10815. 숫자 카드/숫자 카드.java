import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] up = new boolean[10_000_001];
    static boolean[] down = new boolean[10_000_001];
    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    private static void init() throws Exception{
        st = new StringTokenizer(br.readLine());
        int inputSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < inputSize; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value < 0){
                value *= -1;
                down[value] = true;
            }else{
                up[value] = true;
            }
        }
    }
    private static void run() throws Exception{
        st = new StringTokenizer(br.readLine());
        int inputSize =Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < inputSize; i++){
            int value = Integer.parseInt(st.nextToken());

            if(value < 0){
                value *= -1;
                if(down[value]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }else{
                if(up[value]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }

            sb.append(" ");
        }

        System.out.print(sb);
    }
}
