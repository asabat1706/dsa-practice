package Strings;

import java.util.Arrays;

public class MinChars {
    public static void main(String[] args){
        String A ="abcabbccd";
        int B = 3; int count=0;
        int[] countchars = new int[26];
        for(int i=0; i<A.length(); i++){
            int index = A.charAt(i)-'a';
            countchars[index] += 1;
        }
        Arrays.sort(countchars);
        for(int i=0; i<countchars.length; i++){
            if(countchars[i] <= B) {
                int c = countchars[i];
                countchars[i] -= B;
                B -= c;
            }
            if(B==0) break;
        }
        for(int i=0; i<countchars.length; i++){
            if(countchars[i]>0) count++;
        }
        System.out.println(count);
    }
}
