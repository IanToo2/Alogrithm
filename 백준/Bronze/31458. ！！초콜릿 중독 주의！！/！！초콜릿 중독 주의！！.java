import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            int front = 0;
            int back = 0;
            char value = 0;
            boolean check = true;
            char[] input = br.readLine().toCharArray();
            for(char output : input){
                if(output == '1' || output =='0'){
                    value = output;
                    check = false;
                    continue;
                }
                if(check){
                    front++;
                }else{
                    back++;
                }
            }
//            System.out.println(front +"," + back);
            if(back != 0 ){
                value = '1';
            }

            if(front %2 == 0){
                System.out.println(value);
            }else{
                if(value == '1' ){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }
        }
    }





}