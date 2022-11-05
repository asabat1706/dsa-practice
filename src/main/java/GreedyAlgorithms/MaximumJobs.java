package GreedyAlgorithms;

public class MaximumJobs {
    public static void main(String[] args){
//        int[] start_times = {1,5,7,1};
//        int[] end_times = {8,7,8,8};

        int[] start_times = {3, 2, 6};
        int[] end_times = {9, 8, 9};
        mergeSort(end_times,start_times,0,start_times.length-1);
//        for(int i=0; i<end_times.length; i++){
//            System.out.print(end_times[i] + "   ");
//        }
//        for(int i=0; i<start_times.length; i++){
//            System.out.print(start_times[i] + "   ");
//        }

        int count = 1; int last_selected_job_end = end_times[0];
        for(int i=1; i<end_times.length; i++){
            if(start_times[i] >= last_selected_job_end){
                count++;
                last_selected_job_end = end_times[i];
            }
        }

        System.out.println(count);
    }

    private static void mergeSort(int[] end_times, int[] start_times, int start, int end) {
        if(start == end) return;
        int mid = (start+end)/2;
        mergeSort(end_times,start_times,start,mid);
        mergeSort(end_times,start_times,mid+1,end);
        merge(end_times,start_times,start,mid,end);
    }

    private static void merge(int[] end_times, int[] start_times, int start, int mid, int end) {
        int l = mid-start+1;
        int r = end-mid;
        int[] left_end = new int[l];
        int[] right_end = new int[r];
        int[] left_start = new int[l];
        int[] right_start = new int[r];
        int index=0;
        for(int k=start; k <= mid; k++){
            left_end[index++] = end_times[k];
        }

        index=0;
        for(int k=start; k <= mid; k++){
            left_start[index++] = start_times[k];
        }

        index=0;
        for(int k=mid+1; k <= end; k++){
            right_end[index++] = end_times[k];
        }

        index=0;
        for(int k=mid+1; k <= end; k++){
            right_start[index++] = start_times[k];
        }


        index=start;
        int index_s = start;
        int i=0, j=0;
        while((i < l) && (j < r)){
            if(left_end[i] <= right_end[j]){
              end_times[index++] = left_end[i];
              start_times[index_s++] = left_start[i];
              i++;
            }
            else{
                end_times[index++] = right_end[j];
                start_times[index_s++] = right_start[j];
                j++;
            }
        }
        if(i < l){
            while(i<l){
                end_times[index++] = left_end[i];
                start_times[index_s++] = left_start[i];
                i++;
            }
        }
        if(j < r){
            while(j<r){
                end_times[index++] = right_end[j];
                start_times[index_s++] = right_start[j];
                j++;
            }
        }
    }
}
