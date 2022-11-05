public class TimeToEquality {
    public static void main(String[] args){
        int A[] = {1,2,3,4};
        int max = A[0]; int count=0;
        for(int i=0; i<A.length; i++)
           if(A[i] > max){
               max = A[i];
           }
        for(int i=0; i<A.length; i++){
            if(A[i] < max){
                count = count + (max-A[i]);
            }

        }
        System.out.println("count "+ count);
    }
}
