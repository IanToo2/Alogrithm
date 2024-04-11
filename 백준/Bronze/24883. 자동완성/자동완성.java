import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        init();
    }
    private static void init() throws Exception{
        String input = br.readLine();
        if(input.equals("N") || input.equals("n")){
            System.out.println("Naver D2");
        }else{
            System.out.println("Naver Whale");
        }
    }
}