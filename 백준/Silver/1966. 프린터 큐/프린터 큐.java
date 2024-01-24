
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            // 데이터 입력 시작
            LinkedList<int[]> queue = new LinkedList<>();

            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            String[] inputData = sc.nextLine().split(" ");

            for(int j = 0 ; j < inputData.length;j++) {
                queue.add(new int[]{j, Integer.parseInt(inputData[j])});
            }
            // 데이터 입력 종료
            int cnt = 0;

            while(!queue.isEmpty()){
                int[] nowData = queue.poll();
                boolean check = true;
                // 로직 시작
                for(int i = 0; i < queue.size();i++){
                    // 맨 앞의 수의 중요도가 이어 지는 수의 중요도보다 작은 경우
                    if(nowData[1] < queue.get(i)[1]){
                        // 꺼내둔 수와 이어지는 수를 모드 큐의 맨 뒤로 보낸다.
                        queue.offer(nowData);
                        for(int j = 0;j<i;j++){
                            queue.offer(queue.poll());
                        }
                        check = false;
                        break;
                    }
                }
                if(check == false){
                    continue;
                }

                cnt +=1;
                if(nowData[0] == M){
                    break;
                }
            }
            System.out.println(cnt);
        }
    }
}

