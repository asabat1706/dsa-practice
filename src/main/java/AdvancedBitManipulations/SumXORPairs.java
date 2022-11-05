package AdvancedBitManipulations;

public class SumXORPairs {
    public static void main(String[] args){
        int[] A = {2, 4, 6}; int ans=0;
        for(int i=0; i<3; i++){
            int count1=0, count0=0;
            for(int j=0; j<A.length; j++){
                if(((A[j]>>i) & 1)==0)
                    count0++;
                else count1++;
            }
            int xors=0;
            if(count0!=0 && count1!=0)
            xors = count0*count1;
            ans += xors;
        }
        System.out.println(ans*2);
    }
}
