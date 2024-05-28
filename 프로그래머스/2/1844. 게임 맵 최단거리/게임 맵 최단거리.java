import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[][] maps) {
        answer = bfs(maps);
        return answer;
    }
    private static int bfs(int[][] maps){
        int r = maps.length;
        int c = maps[0].length;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] v = new boolean[r][c];
        Deque<int[]> q = new ArrayDeque<>();
        int answer = -1;
        v[0][0] = true;
        q.add(new int [] {0,0,1});
               
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == r-1 && cur[1] == c-1){
                return cur[2];
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= r || ny >=c || v[nx][ny] || maps[nx][ny] == 0){
                    continue;
                }
                
                v[nx][ny] = true;
                q.add(new int [] {nx,ny,cur[2]+1});
            }
        }
        
        return answer;
    }
}