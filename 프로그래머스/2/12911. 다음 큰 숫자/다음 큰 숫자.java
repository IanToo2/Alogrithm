import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryN = Integer.toBinaryString(n);
        int cnt = 0;
        int startIdx = -1;
        int finIdx = -1;
        boolean check = false;
        for(int i = binaryN.length()-1 ; i >= 0; i --){
            if(finIdx == -1 && binaryN.charAt(i) == '1'){
                finIdx = 0;
                startIdx = i;
                check =true;
            }
            
            if(finIdx == 0 && binaryN.charAt(i) == '0'){
                check = false;
                finIdx = i;
            }
            // System.out.print(binaryN.charAt(i));
        }
        
        int[] arr;
        
        if(finIdx == 0){
            int size = binaryN.length();
            
            answer += Math.pow(2, size);
            for(int i = size; i > size - (startIdx-finIdx); i--){
                answer += Math.pow(2, (size-i));
            }
        }else{
            int size = binaryN.length()-1;
            
            for(int i = 0 ; i < finIdx ; i++){
                if(binaryN.charAt(i) == '1'){
                    answer += Math.pow(2, size-i);
                }   
            }
            
            answer += Math.pow(2, size-finIdx);
            
            for(int i = size; i > size - (startIdx-finIdx) +1 ; i--){
                answer += Math.pow(2, size-i);    
            }
        }
        
        return answer;
    }
}