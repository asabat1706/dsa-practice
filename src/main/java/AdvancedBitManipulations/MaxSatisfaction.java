package AdvancedBitManipulations;

public class MaxSatisfaction {
    public static void main(String[] args){
//        int[] A = {61, 67, 7, 99, 7, 127, 7, 255, 58, 38, 68};
        int[] A={16, 99, 1, 84, 255, 7, 7, 3, 3, 7, 255, 3};
        int ans=0;
        for(int i=31; i>=0; i--){
            int count_1s=0; int bit=32;
            for(int j=0; j<A.length; j++){
                if(A[j]!= -1 && (((A[j]>>i)&1) > 0)) {
                    count_1s++;
                    bit=i;
                }
            }
            if(count_1s>=4){
                for(int k=0; k<A.length; k++){
                    if(A[k] != -1 && (((A[k]>>bit) & 1) == 0))
                        A[k] = -1;
                }
                ans += (1<<bit);
            }
        }

        System.out.println(ans);
    }
}
