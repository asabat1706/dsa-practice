package Strings;

public class LongestPrefixSeq {
    public static void main(String[] args){
        String[] A={"abc", "abc", "abc"};
        int minLen = Integer.MAX_VALUE;
        String com="";
        for(String s:A){
            if(s.length()<minLen)
                minLen = s.length();
        }
        if(A.length > 1) {
            for (int i = 0; i < minLen; i++) {
                char ch = A[0].charAt(i);
                boolean isSame = false;
                for (int j = 1; j < A.length; j++) {
                    if (A[j].charAt(i) == ch)
                        isSame = true;
                    else {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) com = com + ch;
                else break;
            }
        }
        else com = A[0];
        System.out.println(com);
    }
}
