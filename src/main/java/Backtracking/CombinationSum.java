package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CombinationSum {
    static ArrayList<ArrayList<Integer>> ans_combinations = new ArrayList<>();
    static HashSet<Integer> combinations_covered = new HashSet<>();
    public static void main(String[] args){
//        int[] A = {2, 3, 4};
//        Arrays.sort(A);
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); A.add(8); A.add(8);
        int k = 9;
        TreeSet<Integer> unique_ele = new TreeSet<>(A);
        ArrayList<Integer> combination = new ArrayList<>();
        findCombinations(unique_ele,k,0,combination,unique_ele.first());
        System.out.println(ans_combinations);
    }

    private static void findCombinations(TreeSet<Integer> a, int k, int sum, ArrayList<Integer> combination, int ele) {
        if(sum > k){
            return;
        }
        if(sum == k){
                ArrayList<Integer> list = new ArrayList<>(combination);
                ans_combinations.add(list);
                return;
        }
        Iterator itr = a.iterator();
        while(itr.hasNext()){
            int num = (int) itr.next();
            if(num >= ele) {
                  sum = sum + num;
                  combination.add(num);
                  findCombinations(a, k, sum, combination, num);
                  sum = sum - num;
                  combination.remove(combination.size() - 1);
            }
        }

    }
}
