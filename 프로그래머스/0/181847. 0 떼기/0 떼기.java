import java.util.*;

class Solution {
    public StringBuilder solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        boolean check = true;
        for(int i = 0 ; i < n_str.length();i++){
            if(n_str.charAt(i) != '0'){
                check = false;
                sb.append(n_str.charAt(i));
                continue;
            }
            
            if(!check){
                sb.append(n_str.charAt(i));
            }
        }
        
        return sb;
    }
}