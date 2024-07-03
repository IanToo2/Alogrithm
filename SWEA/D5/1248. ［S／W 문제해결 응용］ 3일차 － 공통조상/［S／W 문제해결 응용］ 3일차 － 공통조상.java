import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int first;
    static int second;

    static Node[] node;
    static class Node{
        int parent;
        List<Integer> child = new ArrayList<>();

        @Override
        public String toString() {
            return "Node{" +
                    "parent=" + parent +
                    ", child=" + child +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        int time = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= time ; i++){
            init();
            sb.append("#").append(i).append(" ");
            logic();
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static void init() throws Exception{
        // V, E, Object 1, Object 2
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        node = new Node[v+1];
        for(int i = 1 ; i <= v ; i++){
            node[i] = new Node();
        }

        int e = Integer.parseInt(st.nextToken());

        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        // Edge setting
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < e ; i++){
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            node[parent].child.add(child);
            node[child].parent = parent;
        }
    }
    private static void logic(){
        // 제일 가까운 루트 찾기
        int root = findRoot();
        sb.append(root).append(" ");
//        System.out.println(root);
        // 루트부터 순회 시작
        if(root != 1) {
            int count = 1;

            boolean[] v = new boolean[node.length];
            Deque<Integer> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : node[cur].child) {
                    if (!v[next]) {
                        v[next] = true;
                        q.add(next);
                        count++;
                    }
                }
            }
            sb.append(count);
        }else{
            sb.append(node.length -1);
        }
//        for(int i = 1; i < node.length; i++){
//            System.out.println(i+"번 " +node[i].toString());
//        }
    }
    private static int findRoot(){

        int returnData;
        boolean[] v = new boolean[node.length];

        int firstParent = first;
        int secondParent = second;


        while(true){
//            System.out.println("first : " + firstParent + " second : " + secondParent);
            if(v[firstParent] && firstParent != 1){
                returnData = firstParent;
                break;
            }
            v[firstParent] = true;
            if(v[secondParent] && secondParent != 1){
                returnData = secondParent;
                break;
            }

            if(firstParent == 1 && secondParent == 1){
                returnData = 1;
                break;
            }

            v[secondParent] = true;

            if(firstParent != 1) {
                firstParent = node[firstParent].parent;
            }
            if(secondParent != 1) {
                secondParent = node[secondParent].parent;
            }
        }

        return returnData;
    }


}
