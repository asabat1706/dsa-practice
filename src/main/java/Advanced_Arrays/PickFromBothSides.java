package Advanced_Arrays;

public class PickFromBothSides {
    public static void main(String[] args){
        int[] A = {1, 2};
        int B=1;
        int last_index = A.length-B;
        int sum=0; int count=0; int max_sum= Integer.MIN_VALUE;
        for(int i=A.length-B; i<A.length-1+B; i++){
            sum += A[i%A.length];
            count++;
            if(count == B){
                max_sum = Math.max(sum, max_sum);
                sum -= A[last_index%A.length];
                last_index++;
                count--;
            }
        }
        System.out.println(max_sum);
    }
}
