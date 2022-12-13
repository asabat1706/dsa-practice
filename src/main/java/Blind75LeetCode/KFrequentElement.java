package Blind75LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class KFrequentElement {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Map<Integer, Integer> freq_map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!freq_map.containsKey(nums[i])){
                freq_map.put(nums[i],1);
            }
            else{
                freq_map.put(nums[i], freq_map.get(nums[i])+1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1,i2)->
                freq_map.get(i1)<freq_map.get(i2)?-1:1);
        Set<Integer> keys = freq_map.keySet();
        int count=0;
        for(Integer key: keys){
            if(count<k){
                minHeap.add(key);
                count++;
            }
            else{
                int top_freq = freq_map.get(minHeap.peek());
                int curr_freq = freq_map.get(key);
                if(curr_freq > top_freq){
                    minHeap.poll();
                    minHeap.add(key);
                }
            }
        }
        System.out.println(minHeap);
    }
}
