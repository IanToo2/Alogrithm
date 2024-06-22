import java.util.*;

class Solution {
    
    static int r, c;
    static List<Integer> cost;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] keep;
    static boolean[][] v;
    
    public int solution(int[][] map) {
        // init
        r = map.length;
        c = map[0].length;
        cost = new ArrayList<>();
        cost.add(0);
        keep = new int[r][c];
        v = new boolean[r][c];
        
        int answer = 0;
        // init
        init(map);
        // 출력
        // print(keep);
        // System.out.println(cost);
        for(int i = 0 ; i < c; i ++){
            answer = Math.max(answer, logic(i));
        }
        return answer;
    }
    private static int logic(int cur){
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < r ; i++){
            set.add(keep[i][cur]);
        }
        // System.out.println(cur + "번 위치에서 확인 시작");
        int answer = 0 ;
        for(Integer idx : set){
            // System.out.println(idx);
            answer += cost.get(idx);
        }
        return answer;
    }
    private static void init(int[][] map){
        int number = 1;
        
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0 ; j < map[0].length; j++){
                // 석유가 없는 지역
                if(map[i][j] == 0 || v[i][j]){
                    continue;
                }
                // System.out.println(i +","+j);
                bfs(i,j,number++, map);
            }
        }
    }
    private static void bfs(int x, int y, int number, int[][] map){
        
        Deque<int[]> q = new ArrayDeque<>();
        int size = 0;
        q.add(new int[] {x,y});
        v[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            keep[cur[0]][cur[1]]=number;
            size++;
            for(int i = 0 ; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                // continue 조건
                if( nx < 0 || ny < 0 || 
                   nx >= map.length || ny >= map[0].length ||
                   v[nx][ny] || map[nx][ny] == 0){
                    continue;
                }
                
                v[nx][ny] = true;
                q.add(new int[] {nx,ny});
            }
        }
        cost.add(size);
    }
    private static void print(int[][] map){
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c; j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }    
}