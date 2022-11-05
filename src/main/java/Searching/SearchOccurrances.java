package Searching;

public class SearchOccurrances {
    public static void main(String[] args){
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 3;
        int first_index = binarySearchFirst(A,B);
        int last_index = binarySearchLast(A,B);
        System.out.println(first_index + "   "+ last_index);
    }

    private static int binarySearchLast(int[] a, int b) {
        int s=0, e=a.length-1; int index=-1;
        while(s <= e){
            int mid = (s+e)/2;
            if(a[mid]==b) {
                index=mid;
                s = (mid+1);
            }
            else if(a[mid]>b){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return index;
    }

    private static int binarySearchFirst(int[] a, int b) {
        int s=0, e=a.length-1; int index=-1;
        while(s <= e){
            int mid = (s+e)/2;
            if(a[mid]==b) {
                index=mid;
                e=(mid-1);
            }
            else if(a[mid]>b){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return index;
    }
}


