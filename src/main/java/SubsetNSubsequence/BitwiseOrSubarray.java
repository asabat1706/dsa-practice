package SubsetNSubsequence;

public class BitwiseOrSubarray {
    public static void main(String[] args) {
        int[] a = {7,8,9,10};
        long sum = 0;
        int factor = (int) Math.pow(10, 9) + 7;
        int[] last_one = new int[27];
        for (int i = 0; i < a.length; i++) {
            for(int j=0; j<a.length; j++){
                long val = (1<<j);
                if(((a[i]>>j)&1) == 1){
                    long cont = (i+1)*val;
                    sum = ((sum%factor) + (cont%factor))%factor;
                    last_one[j] = (i+1);
                }
               else{
                    long cont = last_one[j]*val;
                    sum = ((sum%factor) + (cont%factor))%factor;
                }
            }
        }
        int final_sum = (int)(sum%factor);
        System.out.println(final_sum);
    }
}
