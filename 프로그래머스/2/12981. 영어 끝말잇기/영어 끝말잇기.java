import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        Set<String> data = new HashSet<>();
        data.add(words[0]);
        
        boolean check = true;
        int turn = 2;
        
        for(int i = 1 ; i < words.length; i++){
            check = data.add(words[i]);
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || !check){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            turn++;
        }
        
        return answer;
    }
}