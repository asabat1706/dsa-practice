package Strings;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args){
        String s = "aabaab!bb";
        HashMap<Character, Integer> hm =  new HashMap<>();
        int start=0, end=0;
        int max_len = 0;
        for(int i=0; i<s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),i);
                end = i;
            }
            else{
                int index = hm.get(s.charAt(i));
                if(index >= start){
                    start = index + 1;
                }
                hm.put(s.charAt(i),i);
                end = i;
            }
            int size = end - start + 1;
            max_len = Math.max(size, max_len);

        }
        System.out.println(max_len);
    }
}
