import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new TreeMap<>();
        int answer = 0;
        for(int key : tangerine){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // System.out.println("Size : " + map.size());
        Integer[] data = new Integer[map.size()];
        
        int idx= 0;
        for(int value : map.values()){
            data[idx++] = value;
        }
        idx = 0;
        Arrays.sort(data, Collections.reverseOrder());
        // System.out.println(Arrays.toString(data));
        while(k > 0){
            k -= data[idx++];
            answer++;
        }
        return answer;
    }
}