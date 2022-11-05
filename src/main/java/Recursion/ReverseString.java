package Recursion;

public class ReverseString {
    public static void main(String[] args){
        String str = "abcd";
        int start=0, end=str.length()-1;
        char[] reverse = reverseString(str.toCharArray(),start,end);
        str="";
        for(int i=0; i<reverse.length; i++){
            str = str+reverse[i];
        }
        System.out.println(str);
    }

    private static char[] reverseString(char[] str, int start, int end) {
        char c2 = str[start];
        char c1 = str[end];
        str[end] = c2; str[start]=c1;
        if(start==(end-1) || start==end){
            return str;
        }
        else{
           return reverseString(str,start+1,end-1);
        }

    }
}
