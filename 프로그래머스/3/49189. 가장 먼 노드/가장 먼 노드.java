import java.io.*;
import java.util.*;

class Solution {
    static Node[] node;
    
    static class Node{
        List<Integer> linked = new ArrayList<>();
    }
    
    public int solution(int n, int[][] edge) {
        node = new Node[n+1];
        for(int i = 1 ; i <= n ; i++){
            node[i] = new Node();
        }
        for(int i = 0 ; i < edge.length;i++){
            int u = edge[i][0];
            int v = edge[i][1];
            
            node[u].linked.add(v);
            node[v].linked.add(u);
        }
        
        int answer = bfs(n);
          
        return answer;
    }
    
    private static int bfs(int n){
        boolean[] v = new boolean[n+1];
        Deque<int[]> q = new ArrayDeque<>();
        
        int maxLen = 0;
        int cnt = 0;
        
        v[1] = true;
        q.add(new int[] {1,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[1] > maxLen){
                maxLen = cur[1];
                cnt = 1;
            }else if(cur[1] == maxLen){
                cnt++;
            }
            
            for(int next : node[cur[0]].linked){
                if(v[next]){
                    continue;
                }
                
                v[next] = true;
                q.add(new int[] {next, cur[1]+1});
            }
        }
        
        return cnt;
    }
}