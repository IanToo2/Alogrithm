class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int size = str1.length();
        
        if(size > str2.length()){
            return 0;
        }
        
        for(int i = 0 ; i < str2.length() - size +1 ; i++){
            String sliceStr = str2.substring(i, i+size);
            System.out.println(sliceStr);
            if(str1.equals(sliceStr)){
                return 1;
            }
        }
        return answer;
    }
}