package Heaps;

public class MaxSumAfterBNegations {
    public static void main(String[] args){
//        int[] A = {57, -3, 14, 87, 42, 38, 31, 7, 28, 61};
//        int B =10;
        int[] A = {24, -68, -29, -9, 84};
        int B = 4;
         int size = A.length-1;
        createMinHeap(A,size);
        int count=0;
        while(count < B){
            int min = deleteMin(A,size);
            min = -min;
            insertintoHeap(A,min,size);
            count++;
        }
        int sum=0;
        for(int i=0; i<A.length; i++){
            System.out.print(A[i] + "    ");
            sum += A[i];
        }
        System.out.println(sum);
    }

    private static void insertintoHeap(int[] a, int min, int last_ind) {
        a[last_ind] = min;
        upHeapify(a,last_ind);
    }

    private static void upHeapify(int[] a, int idx) {
        int parent = (idx-1)/2;
        while((idx !=0) && (a[idx] < a[parent])){
            int temp = a[idx];
            a[idx] = a[parent];
            a[parent] = temp;
            idx = parent;
            parent = (idx -1)/2;
        }
    }

    private static int deleteMin(int[] a, int size) {
        int temp = a[0];
        a[0] = a[size];
        a[size] = temp;
        int min = a[size];
        size--;
        downHeapify(a,0,size);
        return min;
    }

    private static void createMinHeap(int[] a, int size) {
        for(int i=size/2; i>=0; i--){
            downHeapify(a,i,size);
        }
    }

    private static void downHeapify(int[] a, int idx, int size) {
        int lc = (2*idx) + 1;
        int rc = (2*idx) + 2;
        if(lc > size) return;
        if(rc > size){
            if(a[lc] < a[idx]){
                int temp = a[idx];
                a[idx] = a[lc];
                a[lc] = temp;
            }
            return;
        }
        if(a[idx] <= a[lc] && a[idx] <= a[rc]){
            return;
        }
        if(a[lc] <= a[rc]){
            int temp = a[idx];
            a[idx] = a[lc];
            a[lc] = temp;
            downHeapify(a,lc,size);
            return;
        }
        int temp = a[idx];
        a[idx] = a[rc];
        a[rc] = temp;
        downHeapify(a,rc,size);
        return;
    }
}
