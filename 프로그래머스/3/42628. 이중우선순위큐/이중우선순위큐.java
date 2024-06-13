import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] answer = {};
        
        for(String data : operations){
            st = new StringTokenizer(data);
            String order = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            // 삽입
            if(order.equals("I")){
                left.add(value);
                right.add(value);
            }
            else{
                if(left.isEmpty()){
                    continue;
                }
                // 최대값 삭제
                if(value > 0){
                    int removeValue = right.poll();
                    System.out.println(removeValue);
                    left.remove(removeValue);
                }
                // 최소값 삭제
                else{
                    System.out.println(left.poll());
                    
                }
            }
        }
        if(left.isEmpty()){
            answer = new int[] {0,0};
        }else{
            answer= new int[]{right.poll(), left.poll()};
        }
        return answer;
    }
}