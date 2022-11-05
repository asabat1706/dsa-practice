package Heaps;

public class ChocolatesAndMagician {
    public static void main(String[] args){
        int[] chocolate_bag = {2,4,6,8,10};
        int time_alloted = 5;
        int max_chocolates_had=0;
        int mod = 1000000007;
        buildMaxHeap(chocolate_bag,chocolate_bag.length-1);
        int time_completed = 0;
        while(time_completed < time_alloted){
           int max = deletemax(chocolate_bag);
           max_chocolates_had = ((max_chocolates_had%mod) + (max%mod))%mod;
           max = max/2;
           insertIntoHeap(chocolate_bag,max);
           time_completed++;
        }
        System.out.println(max_chocolates_had);
    }

    private static void insertIntoHeap(int[] chocolate_bag, int max) {
        int n = chocolate_bag.length-1;
        chocolate_bag[n] = max;
        upHeapify(chocolate_bag,n);
    }

    private static void upHeapify(int[] chocolate_bag, int idx) {
        int parent = (idx-1)/2;
        while(chocolate_bag[idx] > chocolate_bag[parent]){
            int temp = chocolate_bag[idx];
            chocolate_bag[idx] = chocolate_bag[parent];
            chocolate_bag[parent] = temp;
            idx = parent;
            parent = (idx-1)/2;
        }
    }

    private static int deletemax(int[] chocolate_bag) {
        int max = chocolate_bag[0];
        int size = chocolate_bag.length-1;
        int temp = chocolate_bag[0];
        chocolate_bag[0] = chocolate_bag[size];
        chocolate_bag[size] = temp;
        size--;
        downHeapify(chocolate_bag,0,size);
        return max;
    }

    private static void buildMaxHeap(int[] chocolate_bag, int length) {
        for(int i=length/2; i>=0; i--){
            downHeapify(chocolate_bag,i,length);
        }

    }

    private static void downHeapify(int[] chocolate_bag, int idx, int length) {
        int lc = (2*idx)+1;
        int rc = (2*idx)+2;
        if(lc > length) return;
        if(rc > length){
            if(chocolate_bag[lc] > chocolate_bag[idx]){
                int temp = chocolate_bag[idx];
                chocolate_bag[idx] = chocolate_bag[lc];
                chocolate_bag[lc] = temp;
            }
            return;
        }
        if((chocolate_bag[idx] >= chocolate_bag[lc]) && (chocolate_bag[idx] >= chocolate_bag[rc])){
            return;
        }
        if(chocolate_bag[lc] >= chocolate_bag[rc]){
            int temp = chocolate_bag[lc];
            chocolate_bag[lc] = chocolate_bag[idx];
            chocolate_bag[idx] = temp;
            downHeapify(chocolate_bag,lc,length);
            return;
        }
        int temp = chocolate_bag[rc];
        chocolate_bag[rc] = chocolate_bag[idx];
        chocolate_bag[idx] = temp;
        downHeapify(chocolate_bag,rc,length);
    }
}
