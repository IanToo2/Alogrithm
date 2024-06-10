import java.util.*;

class Solution {
    public StringBuilder solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        
        for(int idx : index_list){
            sb.append(my_string.charAt(idx));
        }
        
        
        return sb;
    }
}