import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double cost = 0;
        char answer = ' ';

        char[] data = {'S','N','U'};
        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine());
            int nowCost = Integer.parseInt(st.nextToken()) * 10;
            if(nowCost >= 5000){
                nowCost -= 500;
            }
            int nowWeight = Integer.parseInt(st.nextToken()) * 10;

            if((double) nowWeight / nowCost > cost){
                cost = (double) nowWeight / nowCost;
                answer = data[i];
            }
//            System.out.println(cost);
        }

        System.out.println(answer);
    }
}
