package Blind75LeetCode;

import java.util.PriorityQueue;

public class MedianFinder {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1,i2)-> i2.compareTo(i1));
    public static void main(String[] args){
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
    }

    public static void addNum(int num){
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }
        else{
            if(num < maxHeap.peek()){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1){
                if(minHeap.size() > maxHeap.size()){
                    int ele = minHeap.poll();
                    maxHeap.add(ele);
                }
                else{
                    int ele = maxHeap.poll();
                    minHeap.add(ele);
                }
            }
        }
    }


    public static double findMedian(){
        if(minHeap == null || maxHeap == null){
            return 0;
        }
        if(minHeap.size() == 0){
            if(maxHeap.size() == 0){
                return 0;
            }else{
                return maxHeap.peek();
            }
        }
        if(maxHeap.size() == 0){
           return minHeap.peek();
        }
        if(Math.abs(minHeap.size() - maxHeap.size()) == 1){
            if(minHeap.size() > maxHeap.size()){
                return minHeap.peek();
            }
            else{
                return maxHeap.peek();
            }
        }
        else{
            return (minHeap.peek()+ maxHeap.peek())/2.0;
        }
    }



}
