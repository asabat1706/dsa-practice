package Sorting;

import java.util.Arrays;

public class AlternatePattern {
    public static void main(String[] args){
        int[] input = {100, -5, 17, 11, -3, 13, 60};
        int[] ans = new int[input.length];
        int neg_count =0;
        int pos_count =0;
        for(int i=0; i< input.length; i++){
            if(input[i] > 0) {
                pos_count++;
            }
            else{
                neg_count++;
            }
        }

        int pos_ind=1; int neg_ind=0;
        int last_pos_idx = -1; int last_neg_idx = -1;

        for(int i=0; i<input.length; i++){
            if((input[i] < 0) && (pos_count > 0)){
               ans[neg_ind] = input[i];
               neg_ind+=2;
               pos_count--;
               last_neg_idx = i;
            }
            else if((input[i] > 0) && (neg_count > 0)){
                ans[pos_ind] = input[i];
                pos_ind+=2;
                neg_count--;
                last_pos_idx = i;
            }
        }
        int index = Math.min(pos_ind,neg_ind);
        if(pos_count > 0){
            for(int i=last_pos_idx+1; i<input.length; i++){
                if(input[i] > 0){
                    ans[index++] = input[i];
                }
            }
        }

        if(neg_count > 0){
            for(int i=last_neg_idx+1; i<input.length; i++){
                if(input[i] < 0){
                    ans[index++] = input[i];
                }
            }
        }



        for(index=0; index<ans.length; index++){
            System.out.print(ans[index] + "  ");
        }
    }
}
