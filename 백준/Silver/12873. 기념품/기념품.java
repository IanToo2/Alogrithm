import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static Deque<Integer> person = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            person.add(i);
        }
    }

    private static void run() {
        int cnt = 1;
        while (person.size() != 1) {
            long now = (long) Math.pow(cnt, 3);
            long deleteNum = (now % person.size()) - 1;
            if(deleteNum == -1){
                deleteNum = person.size()-1;
            }
            deletePerson(deleteNum);

            cnt++;
        }
        System.out.println(person.poll());
    }
    private static void deletePerson(long deleteNum){
        for(int i = 0 ; i < deleteNum;i++){
            person.add(person.poll());
        }
        person.poll();
    }
}
