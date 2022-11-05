package DynamicProgramming;

import java.util.ArrayList;

public class TargetSum {
    static ArrayList<ArrayList<Integer>> target_sum = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args){
        int[] A = {1,1,1,1,1};
        int target = 3;
        formTargetSum(A,0,target);
        System.out.println(target_sum);
    }

    private static void formTargetSum(int[] input, int index, int target) {
        if(index == input.length){
            int sum=0;
            for(int i=0; i<ans.size(); i++){
                sum += ans.get(i);
            }
            if(sum == target){
                ArrayList temp = new ArrayList(ans);
                target_sum.add(temp);
            }
            return;
        }
        ans.add(input[index]);
        formTargetSum(input,index+1,target);
        ans.remove(ans.size()-1);
        ans.add(-input[index]);
        formTargetSum(input,index+1,target);
        ans.remove(ans.size()-1);
    }
}
