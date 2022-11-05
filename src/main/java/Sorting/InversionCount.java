package Sorting;


public class InversionCount {
    static int count_smaller = 0;
    static int mod = (int)Math.pow(10,9)+7;
    public static void main(String[] args){
        int A[] = {28, 18, 44, 49, 41, 14};
        mergeSort(A,0,A.length-1);
        System.out.println(count_smaller);
    }

    private static void mergeSort(int[] a, int s, int e) {
        if(s==e) return;
        int mid = (e+s)/2;
        mergeSort(a,s,mid);
        mergeSort(a,mid+1,e);
        merge(a,s,mid,e);

    }

    private static void merge(int[] a, int s, int mid, int e) {
        int first_half = mid-s+1;
        int second_half = e-mid;
        int[] first = new int[first_half]; int[] second = new int[second_half];
        int index=0;
        for(int i=s; i<=mid; i++){
            first[index]=a[i];
            index++;
        }
        index=0;
        for(int i=(mid+1); i<=e; i++){
            second[index]=a[i];
            index++;
        }
        int i=0, j=0;
        index=s;
        while(i<first_half && j<second_half){
            if(first[i] <= second[j]){
                a[index]=first[i];
                i++; index++;
            }
            else{
                a[index] = second[j];
                j++; index++;
                count_smaller = ((count_smaller%mod) + ((first_half-i)%mod))%mod;
            }
        }
        while(i < first_half){
            a[index]=first[i];
            index++; i++;
        }
        while(j < second_half){
            a[index]=second[j];
            index++; j++;
        }
    }
}
