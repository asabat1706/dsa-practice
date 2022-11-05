package Sorting;

public class QuckSort {
    public static void main(String[] args){
        int[] A = {1, 4, 10, 2, 1, 5};
        A = quickSort(A,0,A.length-1);
        for(int k=0; k<A.length; k++)
            System.out.print(A[k]+" ");
    }

    private static int[] quickSort(int[] a, int s, int e) {
        if(s>e) return null;
        else if(s==e) return a;
        int part_ind = partition(a,s,e);
        quickSort(a,s,part_ind-1);
        quickSort(a,part_ind+1,e);
        return a;
    }

    private static int partition(int[] A, int s, int e) {
        int pivot_index = e;
//        System.out.println(A[pivot_index] + "-----");
        int i=s;
        for(int j=s; j<=e; j++){
            if(A[j] < A[pivot_index]){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
        }

        int temp=A[i];
        A[i] = A[pivot_index];
        A[pivot_index] = temp;
        return i;
    }
}
