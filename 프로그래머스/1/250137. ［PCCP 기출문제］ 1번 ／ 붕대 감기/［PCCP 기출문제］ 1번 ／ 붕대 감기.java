import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int max = 0;
        int time = 1;
        Deque<int[]> attack = new ArrayDeque<>();
        for(int[] data : attacks){
            attack.add(data);
        }
        
        int maxhealth = health;

        while(!attack.isEmpty()){
            // 몬스터 공격을 받는 경우
            if(attack.peekFirst()[0] == time){
                max = 0;
                
                health-= attack.poll()[1];
                System.out.println("몬스터 공격 발생");
                System.out.println("남은 몬스터 공격 수 : " + attack.size());
                
                if(health <= 0 ){
                    health=-1;
                    break;
                }
                
            }
            // 붕대를 감는 경우
            else{
                health+=bandage[1];
                max++;
                if(max == bandage[0]){
                    health+= bandage[2];
                    max = 0;
                }
                if(health > maxhealth){
                    health = maxhealth;
                }
            }
            System.out.println("time : " + time);
            System.out.println("체력 : " + health);
            time++;
            System.out.println();
        }
        return health;
    }
}