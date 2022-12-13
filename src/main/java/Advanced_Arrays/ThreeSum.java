package Advanced_Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        int[] nums = {-2,0,1,1,2};
        Arrays.sort(nums);
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Set<List<Integer>> unique_triplets = new HashSet<>();
        for(int i=0; i<=nums.length-3; i++){
            int req_sum = -nums[i];
            int j = i+1; int k= nums.length-1;
            while(j < k){
                if((nums[j] + nums[k]) < req_sum){
                    j++;
                    continue;
                }
                else if((nums[j] + nums[k]) > req_sum){
                    k--;
                    continue;
                }
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]); triplet.add(nums[j]); triplet.add(nums[k]);
                if(!unique_triplets.contains(triplet)){
                    triplets.add(triplet);
                }
                unique_triplets.add(triplet);
                j++; k--;
            }
        }

        return triplets;

    }
}
