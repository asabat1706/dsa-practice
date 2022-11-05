package GreedyAlgorithms;

import java.util.PriorityQueue;

public class FreeCars {
    public static void main(String[] args){
//       int[] free_time = {1, 3, 2, 3, 3};
//       int[] profits = {5, 6, 1, 3, 9};

//        int[] free_time = {3, 8, 7, 5};
//        int[] profits = {3, 1, 7, 19};

        int[] free_time = {1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
        int[] profits = {8, 11, 7, 7, 10, 8, 7, 5, 4, 9};

        int mod = 1000000007;

       mergeSort(free_time, profits, 0, free_time.length-1);
//       for(int i=0; i<free_time.length; i++){
//           System.out.print(free_time[i] + "  ");
//       }
//        System.out.println();
//       for(int i=0; i<profits.length; i++){
//            System.out.print(profits[i] + "  ");
//       }

       PriorityQueue<Integer> pq = new PriorityQueue<>();
       int time=0;
       long total_val=0;
       for(int i=0; i<free_time.length; i++){
           if(time < free_time[i]){
               pq.add(profits[i]);
               total_val += profits[i];
               time++;
           }
           else{
               if((!pq.isEmpty()) && (profits[i] > pq.peek())){
                   int min = pq.poll();
                   total_val -= min;
                   pq.add(profits[i]);
                   total_val += profits[i];
               }
           }
       }
        System.out.println(total_val);
    }

    private static void mergeSort(int[] free_time, int[] profits, int start, int end) {
        if(start==end) return;
        int mid = (start+end)/2;
        mergeSort(free_time,profits,start,mid);
        mergeSort(free_time,profits,mid+1,end);

        merge(free_time,profits,start,mid,end);
    }

    private static void merge(int[] free_time, int[] profits, int start, int mid, int end) {
        int l = mid - start + 1;
        int r = end - mid;
        int[] left_time = new int[l];
        int[] left_profit = new int[l];

        int[] right_time = new int[r];
        int[] right_profit = new int[r];

        int index=0;
        for(int i=start; i<=mid; i++){
            left_time[index] = free_time[i];
            left_profit[index] = profits[i];
            index++;
        }
        index=0;
        for(int i=mid+1; i<=end; i++){
            right_time[index] = free_time[i];
            right_profit[index] = profits[i];
            index++;
        }
        index=start;
        int i=0, j=0;
        while((i<l) && (j<r)){
            if(left_time[i] <= right_time[j]){
                free_time[index] = left_time[i];
                profits[index] = left_profit[i];
                index++;
                i++;
            }
            else{
                free_time[index] = right_time[j];
                profits[index] = right_profit[j];
                index++;
                j++;
            }
        }

        if(i < l) {
            while (i < l) {
                free_time[index] = left_time[i];
                profits[index] = left_profit[i];
                index++;
                i++;
            }
        }

        if(j < r) {
            while (j < r) {
                free_time[index] = right_time[j];
                profits[index] = right_profit[j];
                index++;
                j++;
            }
        }
    }
}
