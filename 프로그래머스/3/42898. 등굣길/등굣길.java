import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // school = m,n;
        int[][] map = new int[m+1][n+1];
        boolean[][] v = new boolean[m+1][n+1];
        
        map[1][1] = 1;
        for(int[] puddle : puddles ){
            int x = puddle[0];
            int y = puddle[1];
            v[x][y] = true;
        }
        
        for(int i = 1 ; i <= m ; i ++){
            for(int j = 1 ; j <= n ; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                if(v[i][j]){
                    continue;
                }
                map[i][j] = (map[i-1][j] + map[i][j-1]) % 1_000_000_007;
            }
        }
        answer = map[m][n];
        // print(map);
        return answer;
    }
    private static void print(int[][] map){
        for(int i = 0 ;i < map.length; i++){
            for(int j = 0 ; j < map[0].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}