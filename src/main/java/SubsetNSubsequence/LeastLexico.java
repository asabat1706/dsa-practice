package SubsetNSubsequence;

import java.util.Arrays;

public class LeastLexico {
    public static void main(String[] args){
        String s = "djjhibvetj";
        char min_char=s.charAt(0);
        String min_str=""; int min_index=-1;
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i)<min_char) {
                min_char = s.charAt(i);
                min_index = i;
            }
        }
       min_str = min_str+min_char;
        min_char = s.charAt(min_index+1);
        for(int j=min_index+2; j<s.length(); j++){
            if(s.charAt(j)<min_char){
                min_char = s.charAt(j);
            }
        }
        System.out.println(min_str+min_char);
    }
}
