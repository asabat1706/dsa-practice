package AdvancedBitManipulations;

public class TwoNumbersNotRepeating {
    public static void main(String[] args){
        int[] A={1, 2, 3, 1, 2, 4};
        int xor=0;
        for(int i=0; i<A.length; i++){
            xor ^= A[i];
        }
        int bit;
        for(bit=0; bit<32; bit++){
            if(((xor>>bit)&1) > 0)
              break;
        }
        int num1=0,num2=0;
        for(int i=0; i<A.length; i++){
            if(((A[i]>>bit)&1) > 0)
                num1 ^= A[i];
            else num2 ^= A[i];
        }
        System.out.println(num1 + "  " + num2);
    }
}
