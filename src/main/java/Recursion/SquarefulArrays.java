package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SquarefulArrays {
    static HashSet<ArrayList<Integer>> unique_permuts = new HashSet<>();
    public static void main(String[] args){
        int[] A = {2226, 175, 114, 82, 39, 10, 39, 42, 102, 94, 75};
//        int[] A = {2,7,2};
        findSquarePermutation(A,0);
        System.out.println(unique_permuts.size());
    }

    private static void findSquarePermutation(int[] input, int index) {
        if(index == input.length){
            ArrayList<Integer> list = new ArrayList();
            for(int i=0; i<input.length; i++){
                list.add(input[i]);
            }
            unique_permuts.add(list);
            return;
        }
        for(int i=index; i<input.length; i++){
            int temp = input[index];
            input[index] = input[i];
            input[i] = temp;
            if (index == 0 || (index > 0 && isPerfectSquare(input[index - 1] + input[index]))) {
                findSquarePermutation(input, index + 1);
            }
            temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }
    }


    private static boolean isPerfectSquare(int i) {
        int num = (int) Math.sqrt(i);
        if((num * num) == i){
            return true;
        }
        return false;
    }
}
