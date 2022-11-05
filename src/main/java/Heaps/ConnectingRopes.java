package Heaps;

public class ConnectingRopes {
    public static void main(String[] args){
//        int[] A ={5, 17, 100, 11};
        int[] A ={1, 2, 3, 4, 5};
        int[] B = createMinHeap(A);
        int total_rope_len = 0;
        int total_cost=0;
        for(int i=0; i<B.length; i++){
            total_rope_len += B[i];
        }
        int rope_len = 0; int size = B.length;
        while((rope_len <= total_rope_len) && (size > 1)){
            int min1 = deletemin(B,size);
//            System.out.println(min1);
            size--;
            int min2 = deletemin(B,size);
//            System.out.println(min2);
            size--;
            rope_len = min1 + min2;
            total_cost += rope_len;
            insertintoHeap(B,rope_len,size);
            size++;
        }
        System.out.println(total_cost);
    }

    private static void insertintoHeap(int[] b, int rope_len, int size) {
        b[size] = rope_len;
        upHeapify(b,size);
    }

    private static void upHeapify(int[] b, int idx) {
        int parent = (idx-1)/2;
        while((idx != 0) && (b[parent] > b[idx])){
            int temp = b[idx];
            b[idx] = b[parent];
            b[parent] = temp;
            idx = (idx-1)/2;
            parent = (idx-1)/2;
        }
    }

    private static int deletemin(int[] b, int n) {
        int temp = b[n-1];
        b[n-1] = b[0];
        b[0] = temp;
        int min = b[n-1];
        n--;
        downHeapify(b,0,n-1);
        return min;
    }

    private static int[] createMinHeap(int[] a) {
        int n = a.length-1;
        for(int i=n/2; i>=0; i--){
            downHeapify(a,i,n);
        }
        return a;
    }

    public static void downHeapify(int[] a,int idx,int n){
        int lc = (2 * idx)+1;
        int rc = (2 * idx)+2;
        if(lc > n) return;
        if(rc > n){
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
            downHeapify(a,lc,n);
            return;
        }
        int temp = a[idx];
        a[idx] = a[rc];
        a[rc] = temp;
        downHeapify(a,rc,n);
    }
}
