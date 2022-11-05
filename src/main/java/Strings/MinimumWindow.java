package Strings;

import java.util.HashMap;

public class MinimumWindow {
    public static void main(String[] args){
//        String A = "0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes";
//        String B= "rsm2ty04PYPEOPYO5";
        String A="YYPP";
        String B="yP";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : B.toCharArray()){
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else hm.put(ch, hm.get(ch)+1);
        }
        int start_index=0,end_index=0,index=0; int expected_count=0; int min_len=Integer.MAX_VALUE;
        int min_start=-1, min_end=-1;
        for(index=start_index; index<=A.length()-hm.size();) {
            while (expected_count < B.length() && index<A.length()) {
                if (hm.containsKey(A.charAt(index))) {
                    expected_count++;
                }
                index++;
            }
            if(expected_count==B.length()) {
                end_index = index - 1;
                int l = end_index - start_index + 1;
                if (l < min_len) {
                    min_start = start_index;
                    min_end = end_index;
                }
            }
            expected_count = 0;
            start_index++;
            index = start_index;
        }
        System.out.println(A.substring(min_start,min_end+1));
    }
}
