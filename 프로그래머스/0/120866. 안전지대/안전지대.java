import java.io.*;
import java.util.*;

class Solution {
    static int r,c, answer;
    static int[] dx = {1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {-1,0,1,-1,0,1,-1,0,1};
    static boolean[][] v;
    
    public int solution(int[][] board) {
        r = board.length;
        c = board[0].length;
        
        answer = 0;
        System.out.println(answer);
        v = new boolean[r][c];
        
        for(int i = 0 ; i < r;i++){
            for(int j = 0 ; j < c ; j ++){
                if(board[i][j] == 1){
                    System.out.println("bomb! : "+i+","+j );
                    bomb(i,j);
                }
            }
        }
        for(int i = 0 ; i < r;i++){
            for(int j = 0 ; j < c ; j ++){
                if(!v[i][j]){
                    System.out.println(i+","+j + "는 생존");
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    private void bomb(int x, int y){
        for(int i = 0 ; i < 9;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= r || ny >= c || v[nx][ny]) continue;
            
            System.out.println(nx + "," + ny);
            v[nx][ny] = true;
        }
    }
}