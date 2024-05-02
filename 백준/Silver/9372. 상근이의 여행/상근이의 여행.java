import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t; i ++){
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken())-1;
            int edge = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < edge;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }
}
