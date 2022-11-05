package DSCarryForward;

public class Bulbs {
    public static void main(String[] args){
        int A[] = {0,1,0,1}; int count=0;
        for(int i=0; i< A.length; i++)
        {
            if(A[i]==0){
                A[i] = 1;
                for(int j=i+1; j<A.length;j++){
                    if(A[j]==0) A[j] = 1;
                    else A[j] = 0;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
