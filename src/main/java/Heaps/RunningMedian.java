package Heaps;


public class RunningMedian {
    public static void main(String[] args){
        int[] streamOfNumbers = {69, 52, 34, 19, 56, 57, 5, 3, 83, 56};
//        int[] streamOfNumbers = {16, 10, 98, 100, 100, 87, 6, 53, 78, 79, 67, 46};
        int n = streamOfNumbers.length;
        int half_len = (n+1)/2;
        int[] maxHeap = new int[half_len];
        int[] minHeap = new int[n - half_len];
        int[] ans = new int[streamOfNumbers.length];
        int max_size = 0, min_size=0; int min=0; int max=0;
        for(int i=0; i<streamOfNumbers.length; i++) {
            if(max_size==0) {
                insertIntoMaxHeap(maxHeap, streamOfNumbers[i], max_size);
                max_size++;
                ans[i]=maxHeap[0];
                continue;
            }
            if(min_size==0){
                if(streamOfNumbers[i] <= maxHeap[0]){
                    max = deleteMax(maxHeap,max_size-1);
                    max_size--;
                    insertIntoMinHeap(minHeap,max,min_size);
                    min_size++;
                    insertIntoMaxHeap(maxHeap, streamOfNumbers[i], max_size);
                    max_size++;
                }
                else {
                    insertIntoMinHeap(minHeap, streamOfNumbers[i], min_size);
                    min_size++;
                }
                ans[i] = maxHeap[0];
                continue;
            }
            if(max_size == min_size){
                if(streamOfNumbers[i] >= minHeap[0]){
                    min = deleteMin(minHeap,min_size-1);
                    min_size--;
                    insertIntoMaxHeap(maxHeap,min,max_size);
                    max_size++;
                    insertIntoMinHeap(minHeap, streamOfNumbers[i], min_size);
                    min_size++;
                }
                else{
                    insertIntoMaxHeap(maxHeap,streamOfNumbers[i],max_size);
                    max_size++;
                }
                ans[i]=maxHeap[0];
                continue;
            }
          if(max_size > min_size) {
              if (streamOfNumbers[i] >= maxHeap[0]) {
                  insertIntoMinHeap(minHeap, streamOfNumbers[i], min_size);
                  min_size++;
              } else {
                  max = deleteMax(maxHeap,max_size-1);
                  max_size--;
                  insertIntoMinHeap(minHeap,max,min_size);
                  min_size++;
                  insertIntoMaxHeap(maxHeap, streamOfNumbers[i], max_size);
                  max_size++;
              }
              ans[i] = maxHeap[0];
          }
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + "    ");
        }
    }

    private static int deleteMin(int[] minHeap, int size) {
        int min = minHeap[0];
        int temp = minHeap[0];
        minHeap[0] = minHeap[size];
        minHeap[size] = temp;
        size--;
        downHeapifyMinHeap(minHeap,0,size);
        minHeap[size+1]=0;
        return min;
    }

    private static int deleteMax(int[] maxHeap, int size) {
        int max = maxHeap[0];
        int temp = maxHeap[0];
        maxHeap[0] = maxHeap[size];
        maxHeap[size] = temp;
        size--;
        downHeapifyMaxHeap(maxHeap,0,size);
        maxHeap[size+1] = 0;
        return max;
    }

    private static void downHeapifyMinHeap(int[] minHeap, int idx, int size) {
        int lc = (2*idx)+1;
        int rc = (2*idx)+2;
        if(lc > size) return;
        if(rc > size){
            if(minHeap[lc] < minHeap[idx]){
                int temp = minHeap[idx];
                minHeap[idx] = minHeap[lc];
                minHeap[lc] = temp;
            }
            return;
        }
        if((minHeap[idx] <= minHeap[lc]) && (minHeap[idx] <= minHeap[rc])){
            return;
        }
        if(minHeap[lc] < minHeap[rc]){
            int temp = minHeap[idx];
            minHeap[idx] = minHeap[lc];
            minHeap[lc] = temp;
            downHeapifyMinHeap(minHeap,lc,size);
            return;
        }
        int temp = minHeap[idx];
        minHeap[idx] = minHeap[rc];
        minHeap[rc] = temp;
        downHeapifyMinHeap(minHeap,rc,size);
    }


    private static void downHeapifyMaxHeap(int[] maxHeap, int idx, int size) {
        int lc = (2*idx)+1;
        int rc = (2*idx)+2;
        if(lc > size) return;
        if(rc > size){
            if(maxHeap[lc] >= maxHeap[idx]){
                int temp = maxHeap[idx];
                maxHeap[idx] = maxHeap[lc];
                maxHeap[lc] = temp;
            }
            return;
        }
        if((maxHeap[idx] >= maxHeap[lc]) && (maxHeap[idx] >= maxHeap[rc])){
            return;
        }
        if(maxHeap[lc] > maxHeap[rc]){
            int temp = maxHeap[idx];
            maxHeap[idx] = maxHeap[lc];
            maxHeap[lc] = temp;
            downHeapifyMaxHeap(maxHeap,lc,size);
            return;
        }
        int temp = maxHeap[idx];
        maxHeap[idx] = maxHeap[rc];
        maxHeap[rc] = temp;
        downHeapifyMaxHeap(maxHeap,rc,size);
    }

    private static void insertIntoMaxHeap(int[] maxHeap, int num, int idx) {
        maxHeap[idx] = num;
        int parent = (idx -1)/2;
        while((idx!=0) && (maxHeap[idx] >= maxHeap[parent])){
            int temp = maxHeap[idx];
            maxHeap[idx] = maxHeap[parent];
            maxHeap[parent] = temp;
            idx = parent;
            parent = (idx-1)/2;
        }
    }

    private static void insertIntoMinHeap(int[] minHeap, int num, int idx) {
        minHeap[idx] = num;
        int parent = (idx -1)/2;
        while((idx!=0) && (minHeap[idx] <= minHeap[parent])){
            int temp = minHeap[idx];
            minHeap[idx] = minHeap[parent];
            minHeap[parent] = temp;
            idx = parent;
            parent = (idx-1)/2;
        }
    }
}
