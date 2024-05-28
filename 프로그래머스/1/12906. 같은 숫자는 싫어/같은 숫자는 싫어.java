import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        int[] answer = {};
        int lastNum = -1;
        List<Integer> returnData = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != lastNum){
                returnData.add(arr[i]);
            }
            lastNum = arr[i];
        }

        return returnData;
    }
}