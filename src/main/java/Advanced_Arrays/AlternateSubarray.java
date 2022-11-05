package Advanced_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlternateSubarray {

    public static void main(String[] args){
        int[] A = {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
        int B = 1;
        ArrayList<Integer> ans =  new ArrayList<>();
        int len = (2*B) + 1 ;
        boolean isGood = true;
        for(int e=len-1; e<A.length; e++)
        {
            int s = e - (len - 1);
            int state = A[s];
            for(int k = s+1; k<= e; k++)
            {
                if(A[k] == (1-state))
                {
                    isGood = true;
                }
                else
                {
                    isGood = false;
                    break;
                }
                state = 1-state;
            }
            if(isGood) {
                ans.add((e+s)/2);
            }
        }
        int[] ans_alt = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ans_alt[i] = ans.get(i);
        }
        System.out.println(ans);
    }
}
