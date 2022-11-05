package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASubsequence {
    public static void main(String[] args){
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>(set);
        int start=0;

        for(int end=9; end<input.length(); end++){
            String sub = input.substring(start,end+1);
            if(!set.contains(sub)){
                set.add(sub);
            }
            else{
               ans.add(sub);
            }
            start++;
        }

        System.out.println(ans);
    }
}
