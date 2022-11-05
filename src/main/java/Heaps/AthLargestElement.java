package Heaps;

public class AthLargestElement {
    public static void main(String[] args){
        int[] B = {15, 20, 99, 1, 6, 42, 2, 33, 87};
//        int[] B = {1, 2, 3, 4, 5, 6};
        int A = 4;
//        int[] B = {15, 20, 99, 1};
//        int A = 2;
        int[] minHeap = new int[A];
        int size=0;
        int[] ans = new int[B.length];
        int index=0;
        while(index < A-1){
            ans[index++] = -1;
        }
        for(int i=0; i<A; i++){
            insertIntoMinHeap(minHeap,B[i],size);
            size++;
        }
        int min = deleteMin(minHeap,size-1);
        ans[index++] = min;
        size--;
        for(int i=A; i<B.length; i++){
            if(B[i] >= min){
                insertIntoMinHeap(minHeap,B[i],size);
                size++;
                min = deleteMin(minHeap,size-1);
                ans[index++] = min;
                size--;
            }
            else{
                ans[index++] = min;
            }
        }
        for(int i=0; i< ans.length; i++){
            System.out.print(ans[i] + "   ");
        }
    }

    private static int deleteMin(int[] minHeap, int size) {
        int min = minHeap[0];
        minHeap[0] = minHeap[size];
        minHeap[size] = 0;
        size--;
        downHeapify(minHeap,0,size);
        return min;
    }

    private static void downHeapify(int[] minHeap, int idx, int size) {
        int lc = (2 * idx)+1;
        int rc = (2 * idx)+2;
        if(lc>size) return;
        if(rc>size){
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
            int temp = minHeap[lc];
            minHeap[lc] = minHeap[idx];
            minHeap[idx] = temp;
            downHeapify(minHeap,lc,size);
            return;
        }
        int temp = minHeap[rc];
        minHeap[rc] = minHeap[idx];
        minHeap[idx] = temp;
        downHeapify(minHeap,rc,size);
    }

    private static void insertIntoMinHeap(int[] minHeap, int ele, int idx) {
        minHeap[idx] = ele;
        int parent = (idx-1)/2;
        while((idx!=0) && (minHeap[idx] < minHeap[parent])){
           int temp = minHeap[idx];
           minHeap[idx] = minHeap[parent];
           minHeap[parent] = temp;
           idx = parent;
           parent = (idx-1)/2;
        }
    }
}
