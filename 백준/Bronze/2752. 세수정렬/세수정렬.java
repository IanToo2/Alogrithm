import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < 3; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }
        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }
}
