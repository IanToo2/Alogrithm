import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        if(s.length()%2 != 0){
            return 0;
        }

        // List<Character> list = new ArrayList<>();
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        
        left.add(s.charAt(0));
        
        for(int i = 1 ; i < s.length(); i ++){
            right.add(s.charAt(i));
        }        
        
        while(!right.isEmpty()){
            
            if(left.isEmpty()){
                left.add(right.poll());
            }
            
            char leftData = left.pollLast();
            char rightData = right.poll();
            
            if(leftData == rightData){
                continue;
            }else{
                left.add(leftData);
                left.add(rightData);
            }
        }
        
        if(left.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}