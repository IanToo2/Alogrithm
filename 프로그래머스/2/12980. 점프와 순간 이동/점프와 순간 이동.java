import java.util.*;

public class Solution {
    
    public int solution(int n) {
        
        int cost = 0;
        
        String binaryN = Integer.toBinaryString(n);
        
        for(int i = 0 ; i < binaryN.length() ; i++){
            if(binaryN.charAt(i) == '1') {
                cost++;
            }
        }
        
        
        return cost;
    }
}