import java.util.*;
class Solution {
    
    static int size;
    static boolean[] v;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        
        v = new boolean[size+1];
        
        recur(k, dungeons, 0);
        int returnAnswer = answer;
        return returnAnswer;
    }
    private static void recur(int k, int[][] dungenons, int depth){
        
        answer = Math.max(depth, answer);
        
        for(int i = 0 ; i < size ; i++){
            if(v[i]){
                continue;
            }
            
            if(k >= dungenons[i][0]){
                v[i] = true;
                recur(k - dungenons[i][1], dungenons, depth+1);
                v[i] = false;
            }
        }
    }
}