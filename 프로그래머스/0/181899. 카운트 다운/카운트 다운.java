import java.util.*;

class Solution {
    public List<Integer> solution(int start, int end_num) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = start; i >= end_num; i--){
            answer.add(i);
        }
        
        return answer;
    }
}