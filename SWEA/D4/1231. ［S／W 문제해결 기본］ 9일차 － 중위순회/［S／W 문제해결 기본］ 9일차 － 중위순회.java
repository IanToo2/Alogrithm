import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Node[] node;
    static class Node{
        char value;
        int left = -1;
        int right = -1;
        Node(char value){
            this.value = value;
        }
    }

    static boolean[] v;

    public static void main(String[] args) throws Exception{
        for(int i = 1 ; i <= 10 ; i++){
            init();
            sb.append("#").append(i).append(" ");
            logic();
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static void init() throws Exception{
        int nodeSize = Integer.parseInt(br.readLine());
        node = new Node[nodeSize + 1];

        for(int i = 1; i<= nodeSize; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char value = st.nextToken().charAt(0);
            node[index] = new Node(value);

            if(st.hasMoreTokens()){
                int left = Integer.parseInt(st.nextToken());
                node[index].left = left;
            }
            if(st.hasMoreTokens()){
                int right = Integer.parseInt(st.nextToken());
                node[index].right = right;
            }
        }
    }
    private static void logic(){
        // root = 1
        v = new boolean[node.length];
        recur(1);
    }
    private static void recur(int idx){
        if(node[idx].left != -1){
            recur(node[idx].left);
        }
        sb.append(node[idx].value);
        if(node[idx].right != -1){
            recur(node[idx].right);
        }
    }
}
