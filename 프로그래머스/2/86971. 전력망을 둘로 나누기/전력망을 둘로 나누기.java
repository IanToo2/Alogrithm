import java.util.*;

class Solution {
    static int max;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int[][] map = new int[n+1][n+1];
        
        max = Integer.MAX_VALUE;
        // 초기 세팅
        for(int[] edge : wires){
            map[edge[0]][edge[1]] = 1;
            map[edge[1]][edge[0]] = 1;
        }
        // print(map, size);
        
        for(int[] edge : wires){
            map[edge[0]][edge[1]] = 0;
            map[edge[1]][edge[0]] = 0;
            System.out.println(Arrays.toString(edge) + "로직 시작");
            logic(map, n);
            map[edge[0]][edge[1]] = 1;
            map[edge[1]][edge[0]] = 1;
        }
        answer = max;
        return answer;
    }
    private static void logic(int[][] map, int n){
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> count = new ArrayList<>();
        boolean[] v = new boolean[n+1];
        for(int i = 1 ; i < n ; i++){
            if(v[i]){
                continue;
            }
            System.out.println(i + "번 노드에서 시작");
            int cnt = 0;
            v[i]=true;
            q.add(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                System.out.println(cur);
                cnt ++;
                
                for(int j = 1; j <= n ; j++){
                    if(map[cur][j] == 1 && !v[j]){
                        v[j] = true;
                        q.add(j);
                    }
                }
            }
            count.add(cnt);
        }
        if(count.size() > 1){
            max = Math.min(max, Math.abs(count.get(0)-count.get(1)));
        }
        System.out.println(count);
        System.out.println(max);
    }
    private static void print(int[][] map, int n){
        for(int i = 1 ; i < n ; i ++){
            for(int j = 1 ; j < n ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}