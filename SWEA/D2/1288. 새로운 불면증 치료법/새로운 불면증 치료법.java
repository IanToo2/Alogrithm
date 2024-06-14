import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int value = Integer.parseInt(br.readLine());
            int answer = logic(value);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static int logic(int n) {
        int value = 0;

        Set<Character> set = new HashSet<>();

        while(set.size() != 10){
            value+=n;

            String strValue = Integer.toString(value);

            for(int i = 0 ; i < strValue.length(); i++){
                set.add(strValue.charAt(i));
            }
        }

        return value;
    }
}
