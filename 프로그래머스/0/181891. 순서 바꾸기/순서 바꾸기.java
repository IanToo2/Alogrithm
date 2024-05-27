class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = num_list.length;
        int idx = 0;
        int[] answer = new int[size];
        
        for(int i = n ; i < size; i++){
            answer[idx] = num_list[i];
            idx++;
        }
        for(int i = 0 ; i < n ; i ++){
            answer[idx] = num_list[i];
            idx++;
        }
        return answer;
    }
}