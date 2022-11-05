package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum2 {
    static ArrayList<ArrayList<Integer>> combination_sum = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<Integer> input = new ArrayList<>();
//        input.add(2); input.add(1); input.add(1);
//        10, 1, 2, 7, 6, 1, 5
      input.add(10);input.add(1);input.add(2);input.add(7);input.add(6);input.add(1);input.add(5);
        int B = 8;
        Collections.sort(input);
        generateCombinationSum(input,0, B, 0);
        System.out.println(combination_sum);
    }

    private static void generateCombinationSum(ArrayList<Integer> input, int index, int sum, int curr_sum) {
        if(curr_sum > sum){
            return;
        }
        if(curr_sum == sum){
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(ans);
            if(!combination_sum.contains(list)) {
                combination_sum.add(list);
            }
            return;
        }
        for(int i=index; i<input.size(); i++){
            ans.add(input.get(i));
            curr_sum += input.get(i);
            generateCombinationSum(input,i+1,sum,curr_sum);
            curr_sum -= input.get(i);
            ans.remove(ans.size()-1);
        }
    }
}
