package Strings;

public class LongestPalindrome {
    public static void main(String[] args){
//        String A = "cacaccbabcabbbaacbbbbcaaaccaacbabcaccbccaacccaacbbaaabbbabcaaabc";
//        String A ="abbcccbbbcaaccbababcbcabca";
        String A = "abba";
        int maxlen=1; String maxSubstring=A.charAt(0)+"";
        if(A.length()>2) {
            for (int p = 1; p < A.length()-1; p++) {
                String str = checkIfPalindrome(A, p,p+1);
                int l = str.length();
                if (l > maxlen) {
                    maxlen = l;
                    maxSubstring = str;
                }
            }
            for (int p = 1; p < A.length(); p++) {
                String str = checkIfPalindrome(A, p-1,p+1);
                int l = str.length();
                if (l > maxlen) {
                    maxlen = l;
                    maxSubstring = str;
                }
            }
        }
        else if(A.length()==2){
            if(A.charAt(0)==A.charAt(1)) maxSubstring = A;
        }
        System.out.println(maxSubstring);
    }

    private static String checkIfPalindrome(String a, int s, int e) {
        String str= "";
        int i=s, j=e;
            while(i>=0 && j<a.length()){
                if(a.charAt(i) == a.charAt(j)){
                    str = a.substring(i,j+1);
                    i--; j++;
                }
                else break;
            }

         return str;
    }
}
