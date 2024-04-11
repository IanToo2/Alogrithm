import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static int[] data;
    static int len = 0;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        data = numbers.clone();
        recur(0,0,target);
        return answer;
    }
    private static void recur(int sum, int depth,int target){
        if(depth == len){
            if(sum == target){
                answer++;
            }
            return;
        }
        recur(sum + data[depth], depth + 1, target);
        recur(sum - data[depth], depth + 1, target);
    }
}