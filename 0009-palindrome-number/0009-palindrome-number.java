class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 ){
            return false;
        }

        String strX = Integer.toString(x);
        int size = strX.length();
        for(int i = 0 ; i < size ; i++){
            if(strX.charAt(i) != strX.charAt(size - i - 1)){
                return false;
            }
        }
        System.out.println(size);

        return true;
    }
}