package Heaps;

public class KPlacesApart {
    public static void main(String[] args){
        int[] A={6,5,3,2,8,10,9};
        int[] sorted_ans= new int[A.length];
        int B = 3;
        int[] minHeap = new int[B+1];
        int size=0;
        for(int i=0; i<=B; i++){
            insertIntoMinHeap(minHeap,A[i],i);
            size++;
        }
        sorted_ans[0] = deleteMin(minHeap,B);
        size--;
        int index=1;
        for(int i=B+1; i< A.length; i++){
            insertIntoMinHeap(minHeap,A[i],size);
            size++;
            int min = deleteMin(minHeap,size-1);
            sorted_ans[index] = min;
            size--;
            index++;
        }
        while(size > 0){
            int min = deleteMin(minHeap,size-1);
            size--;
            sorted_ans[index] = min;
            index++;
        }
        for(int i=0; i<sorted_ans.length; i++){
            System.out.print(sorted_ans[i] + "  ");
        }
    }

    private static int deleteMin(int[] minHeap, int size) {
        int min = minHeap[0];
        int temp = minHeap[0];
        minHeap[0] = minHeap[size];
        minHeap[size] = temp;
        size--;
        donwnHeapify(minHeap,0,size);
        minHeap[size+1] = 0;
        return min;
    }

    private static void donwnHeapify(int[] minHeap, int idx, int size) {
        int lc = (2 * idx)+1;
        int rc = (2 * idx)+2;
        if(lc>size) return;
        if(rc > size){
            if(minHeap[lc] < minHeap[idx]){
                int temp = minHeap[idx];
                minHeap[idx] = minHeap[lc];
                minHeap[lc] = temp;
            }
            return;
        }
        if(minHeap[idx] <= minHeap[lc] && minHeap[idx] <= minHeap[rc]){
            return;
        }
        if(minHeap[lc] < minHeap[rc]){
            int temp = minHeap[idx];
            minHeap[idx] = minHeap[lc];
            minHeap[lc] =temp;
            donwnHeapify(minHeap,lc,size);
            return;
        }
        int temp = minHeap[idx];
        minHeap[idx] = minHeap[rc];
        minHeap[rc] =temp;
        donwnHeapify(minHeap,rc,size);
    }

    private static void insertIntoMinHeap(int[] minHeap, int ele, int idx) {
        minHeap[idx] = ele;
        int parent = (idx-1)/2;
        while((idx!=0) && (minHeap[parent]>minHeap[idx])){
           int temp = minHeap[idx];
           minHeap[idx] = minHeap[parent];
           minHeap[parent] = temp;
           idx = parent;
           parent = (idx-1)/2;
        }
    }
}
