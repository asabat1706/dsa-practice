package Strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args){
        String A = "academy";
//        for(int i=0; i<(A.length()/2); i++){
//            char temp1 = A.charAt(i);
//            char temp2 = A.charAt(A.length()-1-i);
//            A = A.substring(0,i)+temp2+A.substring(i+1,A.length()-1-i)+
//                    temp1+A.substring(A.length()-i,A.length());
//        }
        char[] B = A.toCharArray();
        for(int i=0; i<(A.length()/2); i++){
            char temp1 = A.charAt(i);
            char temp2 = A.charAt(A.length()-1-i);
            B[A.length()-1-i] = temp1;
            B[i] = temp2;
        }
        A= new String(B);
        System.out.println(A);
    }
}
