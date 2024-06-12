import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> lope = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        init();
        run();
    }
    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < size ; i ++){
            lope.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(lope);

    }
    private static void run(){
        Long max = Long.MIN_VALUE;
        for(int i = 0 ; i < lope.size() ; i ++){
            max = Math.max(max, lope.get(i) * (lope.size() - i));
        }
        System.out.println(max);
    }

}
