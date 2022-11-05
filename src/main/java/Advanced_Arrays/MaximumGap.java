package Advanced_Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        int[] A = {829, 881, 624, 775, 793, 247, 742, 172,
                  204, 640, 745, 141, 653, 458, 101, 287};
        int[] right_max = new int[A.length];
        int[] left_min = new int[A.length];
        right_max[A.length - 1] = A.length - 1;
        left_min[0] = 0;
        for (int i = A.length-2; i >= 0; i--) {
             if(A[i] > A[right_max[i+1]]){
                 right_max[i] = i;
             }
             else{
                 right_max[i] = right_max[i+1];
             }
        }
        for(int i = 1; i<A.length; i++) {
            if(A[i] < A[left_min[i-1]]){
                left_min[i] = i;
            }
            else{
                left_min[i] = left_min[i-1];
            }
        }
        for(int i=0; i<right_max.length; i++){
            System.out.print(right_max[i] + "   ");
        }
        System.out.println();
        for(int i=0; i<left_min.length; i++){
            System.out.print(left_min[i] + "   ");
        }

    }
}
