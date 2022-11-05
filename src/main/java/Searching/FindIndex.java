package Searching;

public class FindIndex {
    public static void main(String[] args){
      int[] A= {1,3,4,5,9};
      int B =6;
      int index= -1;
      if(B<=A[0]) index=0;
      else if(B>=A[A.length-1]) index = A.length;
      else index = binarySearch(A,B);
      System.out.println(index);
    }

    private static int binarySearch(int[] a, int b) {
        int s=0, e=a.length-1; int ind=-1;
        while(s<=e){
            int mid = (e+s)/2;
            if(a[mid] == b) return mid;
            else if(a[mid] > b){
                e = (mid-1);
            }
            else if(a[mid] < b){
                ind = mid+1;
                s = mid+1;
            }
        }
        return ind;
    }
}
