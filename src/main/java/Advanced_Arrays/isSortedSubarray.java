package Advanced_Arrays;

public class isSortedSubarray {
    public static void main(String[] args){
       int[] A = {11, 18, -15, -20, -25, 5, -9, -12, -18, 28};
       int[][] B = {{5,9}, {5,10}};
       int[] ans = new int[B.length];
       for(int i=0; i<B.length; i++){
           int s = B[i][0]-1, e = B[i][1]-1;
           int max = A[s]; boolean isSorted = true;
           for(int k=s+1; k<=e; k++){
               if(A[k] < max){
                   isSorted = false;
                   break;
               }
               max = A[k];
           }
           if(isSorted){
               ans[i] = 1;
           }
       }
       for(int i=0; i<ans.length; i++){
           System.out.print(ans[i] + "   ");
       }
    }
}
