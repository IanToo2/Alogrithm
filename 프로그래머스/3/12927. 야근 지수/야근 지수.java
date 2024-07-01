import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            q.add(work);
        }
        while(n-- > 0){
            int work = q.poll();
            if(work == 0){
                
                return 0;
            }
            q.add(work-1);
        }
        
        while(!q.isEmpty()){
            int work = q.poll();
            answer += work*work;
        }
        
        return answer;
    }
}