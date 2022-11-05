package Advanced_Arrays;

public class MaxAbsDiff {
    public static void main(String[] args){
        int[] A = {1, 3, -1};
        int ans=0;
        int addmax=A[0], addmin=A[0];
        int submax=A[0], submin=A[0];
        for(int i=0; i<A.length; i++){
            int n = A[i]+i;
            if(n > addmax) addmax=n;
            else if(n < addmin) addmin=n;
        }
        ans = addmax-addmin;
        for(int i=0; i<A.length; i++){
            int n = A[i]-i;
            if(n > submax) submax=n;
            else if(n < submin) submin=n;
        }
        ans = Math.max(ans,(submax-submin));
        System.out.println(ans);
    }
}
