import java.util.*;

class Solution {
    public Set solution(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        s = s.substring(2, s.length()-2);

        s = s.replace("},{",  "-");
        String[] arr = s.split("-");

        Arrays.sort(arr, Comparator.comparingInt(String::length));
        StringTokenizer st;
        for(String data : arr){
            st = new StringTokenizer(data, ",");
            while(st.hasMoreTokens()){
                String value = st.nextToken();
                set.add(Integer.parseInt(value));
            }
        }
        return set;
    }
}