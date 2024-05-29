import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        
        int sum = 1;
        // n = 1;
        if(n==1){
            return 1;
        }
        while(left <= n && right <= n){
            
            // System.out.println("left : " + left );
            // System.out.println("right : " + right);
            // System.out.println("sum : " + sum + "\n");
            
            if(sum < n){
                right++;
                sum += right;
            }else if(sum >= n){
                sum -= left;
                left++;
            }
            
            if(sum == n){
                answer++;
            }
            
        }
        System.out.print(answer);
        return answer;
    }
}