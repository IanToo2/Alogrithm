import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] check = new int[10];
        int[] v = new int[priorities.length];
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < priorities.length; i++){
            check[priorities[i]]++;
            q.add(new int[] {priorities[i], i});
        }
        int cur = moveCur(check);
        int time = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == cur){
                // System.out.println(Arrays.toString(now));
                check[cur]--;
                v[now[1]] = time;
                time++;
                if(check[cur]==0){
                    cur = moveCur(check);
                }
                continue;
            }else{
                q.add(now);
            }
        }
        
        // System.out.println(Arrays.toString(v));
        answer = v[location];
        return answer;
    }
    private static int moveCur(int[] check){
        for(int i = 9; i >= 0 ; i--){
            if(check[i] != 0){
                return i;
            }
        }
        
        return -1;
    }
}