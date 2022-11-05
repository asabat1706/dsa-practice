package BitManipulation;

public class MissingAndRepeatedNumber {
    public static void main(String[] args){
        int[] A = {3,1,2,5,3};
        int xor_all = A[0];
        for(int i=1; i<A.length; i++){
            xor_all ^= A[i];
        }
        for(int i=1; i<=A.length; i++) {
            xor_all ^= i;
        }
        int bit = 0;
        for(int i=0; i<32; i++){
            if((xor_all & (1<<i)) >= 1){
                bit = i;
                break;
            }
        }
        int xor_ones = 0,xor_zeroes= 0;
        for(int i=1; i<=A.length; i++){
            if((i & (1<<bit)) >= 1){
                xor_ones ^= i;
            }
            else{
                xor_zeroes ^= i;
            }
        }
        for(int i=0; i<A.length; i++){
            if((A[i] & (1<<bit)) >= 1){
                xor_ones ^= A[i];
            }
            else{
                xor_zeroes ^= A[i];
            }
        }
        System.out.println(xor_ones + "   " + xor_zeroes);
    }

}
