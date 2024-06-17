import java.util.*;

class Solution {
    public Set solution(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        // String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s = s.substring(2, s.length()-2);

        s = s.replace("},{",  "-");
        String[] arr = s.split("-");

        Arrays.sort(arr, Comparator.comparingInt(String::length));
        StringTokenizer st;
        // System.out.println("set add...");
        for(String data : arr){
            st = new StringTokenizer(data, ",");
            while(st.hasMoreTokens()){
                String value = st.nextToken();
                // System.out.println(value);
                set.add(Integer.parseInt(value));
            }
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(set);
        return set;
    }
}