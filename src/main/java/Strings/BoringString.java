package Strings;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class BoringString {
    public static void main(String[] args){
        String A = "aab"; int ans=-1;
        int min_even= Integer.MAX_VALUE, max_even= Integer.MIN_VALUE;
        int min_odd= Integer.MAX_VALUE, max_odd= Integer.MIN_VALUE;
        for(int i = 0; i < A.length(); i++) {
            int val = A.charAt(i);
            if((val&1) == 0) {
                min_even = Math.min(min_even,val);
                max_even = Math.max(max_even,val);
            } else {
                min_odd = Math.min(min_odd,val);
                max_odd = Math.max(max_odd,val);
            }
        }
        if((Math.abs(min_even-max_odd) != 1) || (Math.abs(min_odd-max_even) != 1))
            ans = 1;
        else ans=0;
        System.out.println(ans);
    }
}
