package Recursion;

public class Palindrome {
    public static void main(String[] args){
        String s="abcde";
        int start=0, end=s.length()-1;
        System.out.println(isPalindrome(s,start,end));
    }

    private static int isPalindrome(String s, int start, int end) {
        if(start==end || start==(end-1)){
            if(s.charAt(start)==s.charAt(end))
                return 1;
            else return 0;
        }
        else{
            if(s.charAt(start)==s.charAt(end))
               return isPalindrome(s,++start,--end);
            else return 0;
        }
    }
}
