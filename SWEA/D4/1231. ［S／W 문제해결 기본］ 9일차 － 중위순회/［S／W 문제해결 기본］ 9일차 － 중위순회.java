import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    static class Node{
        char value;
        Node left;
        Node right;
    }

    public static void main(String[] args) throws Exception{
        for(int i = 1; i <= 10; i++){
            init();
            
            sb.append("#").append(i).append(" ");
            inorder(tree[1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void init() throws Exception{
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        tree = new Node[size+1];
        for(int i = 1; i <=size;i++){
            tree[i] = new Node();
        }

        // root => always num 1
        for(int i = 0; i < size ; i++){
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            // node value
            tree[nodeNum].value = (st.nextToken()).charAt(0);
            // left child
            if(st.hasMoreTokens()){
                int leftNode = Integer.parseInt(st.nextToken());
                tree[nodeNum].left = tree[leftNode];
            }
            // right child
            if(st.hasMoreTokens()){
                int rightNode = Integer.parseInt(st.nextToken());
                tree[nodeNum].right = tree[rightNode];
            }
        }
    }
    private static void inorder(Node cur){
        if(cur.left != null) inorder(cur.left);
        sb.append(cur.value);
        if(cur.right != null) inorder(cur.right);
    }
}
