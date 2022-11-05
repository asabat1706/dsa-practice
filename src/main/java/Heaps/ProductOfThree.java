package Heaps;

public class ProductOfThree {
    public static void main(String[] args){
//        int[] A = {10, 2, 13, 4};
        int[] A = {1, 2, 3, 4, 5};
        int[] B = new int[A.length];
        int[] ans =  new int[B.length];
        ans[0] = -1; ans[1] = -1;
        for(int i=0; i<A.length; i++){
            insertIntoMaxHeap(B,A[i],i);
            if(i > 1){
               int size = i;
               int max1 = deleteMax(B,size);
               size--;
               int max2 = deleteMax(B,size);
               size--;
               int max3 = deleteMax(B,size);
               size--;
               int max_prod = max1 * max2 * max3;
               ans[i] = max_prod;
                insertIntoMaxHeap(B,max1,size+1);
                size++;
                insertIntoMaxHeap(B,max2,size+1);
                size++;
                insertIntoMaxHeap(B,max3,size+1);
            }
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + "   ");
        }
    }

    private static int deleteMax(int[] b, int size) {
        int temp = b[size];
        b[size] = b[0];
        b[0] = temp;
        int max = b[size];
        size--;
        downHeapify(b,0,size);
        return max;
    }

    private static void downHeapify(int[] b, int idx, int size) {
        int lc = (2*idx) + 1;
        int rc = (2*idx) + 2;
        if(lc > size) return;
        if(rc > size){
            if(b[lc] >=  b[idx]){
                int temp = b[idx];
                b[idx] = b[lc];
                b[lc] = temp;
            }
            return;
        }
        if((b[idx] >= b[lc]) && (b[idx] >= b[rc])){
            return;
        }
        if(b[lc] >= b[rc]){
            int temp = b[lc];
            b[lc] = b[idx];
            b[idx] = temp;
            downHeapify(b,lc,size);
            return;
        }
        int temp = b[rc];
        b[rc] = b[idx];
        b[idx] = temp;
        downHeapify(b,rc,size);

    }

    private static void insertIntoMaxHeap(int[] b, int num, int size) {
        b[size] = num;
        upheapify(b,size);
    }

    private static void upheapify(int[] b, int idx) {
        int parent = (idx-1)/2;
        while(idx!=0 && b[parent] < b[idx]){
            int temp = b[idx];
            b[idx] = b[parent];
            b[parent] = temp;
            idx = parent;
            parent = (idx-1)/2;
        }
    }
}
