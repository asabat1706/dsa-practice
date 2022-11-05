package Advanced_Arrays;

public class MissingInt {
    public static void main(String[] args){
        int[] A = {1};
        int ans=-1;
        for(int i=0; i<A.length; i++){
            while(A[i] > 0 && A[i]<= A.length){
                if(A[i] == i+1 || A[i] == A[A[i]-1])
                    break;
                else{
                    int t = A[A[i]-1];
                    A[A[i]-1] = A[i];
                    A[i] = t;
                }
            }
        }
        int n=1;
      for(int i=0; i<A.length; i++){
          if(A[i] == n) {
              n++;
          }
          else {
              break;
          }
      }
        ans=n;
        System.out.println(ans);
    }
}
