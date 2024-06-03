import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // brown = 2 ( (a-1) + (b-1) ) = 2a + 2b - 4
        
        // yellow = a-2 * b-2 
        
        int left = 3;
        int right = 3;
        while(true){
            if(left < right){
                left++;
                right=3;
            }
            
            if(2*(left+right)-4 == brown && (left-2)*(right-2) == yellow){
                answer[0] = left;
                answer[1] = right;
                break;
            }else{
                right++;
            }
            
        }
        return answer;
    }
}