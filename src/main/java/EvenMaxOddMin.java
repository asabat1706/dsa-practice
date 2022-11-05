public class EvenMaxOddMin {
    public static void main(String[] args){
        int A[] = {0,2,9};
        int max_even=A[0], min_odd = A[0];
        for(int i=0; i<A.length; i++){
            if(A[i]%2==0)
            {
                max_even = A[i];
                break;
            }
        }
        for(int i=0; i<A.length; i++){
            if(A[i]%2!=0)
            {
                min_odd = A[i];
                break;
            }
        }
        for(int i=0; i<A.length; i++){
            if(A[i]%2==0){
                if(A[i] > max_even)
                    max_even = A[i];
            }
            else{
                if(A[i] < min_odd)
                    min_odd = A[i];
            }
        }
        System.out.println(max_even - min_odd);
    }
}
