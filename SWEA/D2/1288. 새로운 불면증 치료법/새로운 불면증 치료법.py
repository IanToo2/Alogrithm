import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
//        System.out.println(t);
        for (int i = 1; i <= t; i++) {
            int value = Integer.parseInt(br.readLine());
            int answer = logic(value);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static int logic(int n) {
        int time = 1;
        int value = n;
//        System.out.println("logic start");
        Set<Character> set = new HashSet<>();

        while(true){
            String strValue = Integer.toString(value);

            for(int i = 0 ; i < strValue.length(); i++){
                set.add(strValue.charAt(i));
            }

//            for(Character data : set){
//                System.out.print(data + " ");
//            }
//            System.out.println();
            if(set.size() == 10){
                break;
            }

            value+=n;
            time++;
        }
        return value;
    }
}
