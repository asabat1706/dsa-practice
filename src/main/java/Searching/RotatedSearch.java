package Searching;

public class RotatedSearch {
    public static void main(String[] args){
       int[] nums = {3,4,5,6,7,8,1,2};
       int target = 2;
       int ans = search(nums,target);
       System.out.println(ans);
    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if((mid-1 >= start) && nums[mid-1] >= nums[start]){
                if(target>=nums[start] && target<=nums[mid-1]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(mid+1 <= end && nums[mid+1] <= nums[end]){
                if(target >= nums[mid+1] && target <= nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else return -1;
        }
        return -1;
    }
}
