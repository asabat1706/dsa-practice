package DSCarryForward;

public class ClosestMinMax {
    public static void main(String[] args){
        int A[] = {1,3};
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int min_index=-1, max_index=-1; int length = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
            if(A[i] < min) min = A[i];
            if(A[i] > max) max = A[i];
        }
        for(int i=0; i<A.length; i++){
            if(A[i]== min){
                min_index = i;
                if(max_index != -1)
                length = Math.min(length,Math.abs(max_index-min_index));
            }
            if(A[i]==max){
                max_index = i;
                if(min_index != -1)
                length = Math.min(length,Math.abs(max_index-min_index));
            }
        }
//        if(length==0) length = 1;
        System.out.println("shortest length "+ (length+1));
    }
}
