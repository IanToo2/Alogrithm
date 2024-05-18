import java.io.*;
import java.util.*;

public class Main {
    static char[] data;
    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = br.readLine().toCharArray();
    }
    private static void run(){
        int right = 0;
        int left = 0;
        int answer = 0;
        for(int i = data.length-1;i>=0;i--    ){
            if(data[i] == ')'){
                right++;
            }else if(data[i] =='('){
                if(right != 0){
                    right--;
                }else{
                    answer++;
                }
            }
        }
        System.out.print((answer+right));
    }
}
