import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int _ = 1; _ <= 10; _++) {
            List<Integer> list = new LinkedList<>();
            // line 1
            int size = Integer.parseInt(br.readLine());
            // line 2
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < size ; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            // line 3
            int orderSize = Integer.parseInt(br.readLine());
            // line 4
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < orderSize ; i++){
                String order = st.nextToken();
                List<Integer> addList;
                int x, y;
                List<Integer> s = new LinkedList<>();
                switch (order){
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0 ; j < y ;j++){
                            list.add(x++, Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0 ; j < y ; j++){
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j < y ; j++){
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }
            sb.append("#").append(_).append(" ");
            for(int i = 0 ; i < 10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
