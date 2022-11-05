package SubArrays;

public class LeastAvg {
    public static void main(String[] args){
        int A[] = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        int PS[] = new int[A.length];
        int B = 9; PS[0] = A[0];
        for(int i=1; i<A.length; i++){
            PS[i] = PS[i-1] + A[i];
        }
        double avg, least_avg=Integer.MAX_VALUE; int index=-1;
        for(int i=B-1; i<A.length; i++){
            if(i==(B-1)) avg = (double)PS[i]/B;
            else avg = (double)(PS[i] - PS[i-B])/B;
            if(avg < least_avg){
                least_avg = avg;
                index = i;
            }
        }
        System.out.println(index-(B-1));
    }
}
