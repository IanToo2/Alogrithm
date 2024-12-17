class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder st = new StringBuilder();
        char curChar = '\0';
        int strsSize = strs.length;
        int minSize = Integer.MAX_VALUE;

        for(int i = 0 ; i < 200 ; i++){
            for(String cur : strs){
                if(i >= cur.length()){
                    return st.toString();
                }
                if(curChar == '\0'){
                    curChar = cur.charAt(i);
                    continue;
                }

                if(curChar != cur.charAt(i)){
                    return st.toString();
                }
            }
            st.append(curChar);
            curChar = '\0';
        }

        return st.toString();    
        
    }
    
}
