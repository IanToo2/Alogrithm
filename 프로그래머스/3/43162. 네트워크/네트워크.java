import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] v;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            if(v[i]){
                continue;
            }
            answer++;
            v[i] = true;
            bfs(i,n, computers);
        }
        return answer;
    }
    
    private static void bfs(int idx,int n, int[][] computers){
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(idx);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0 ; i < n ; i++){
                if(computers[cur][i] == 0 || v[i]){
                    continue;
                }
                v[i] = true;
                q.add(i);
            }
        }
        
    }
}