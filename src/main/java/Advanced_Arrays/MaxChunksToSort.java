package Advanced_Arrays;

public class MaxChunksToSort {
    public static void main(String[] args){
        int[] A = {0,2,1,3,6,4,5,9,8,7};
        int part_num=0, curr_max = A[0];

        for(int i=0; i<A.length; i++){
            if(A[i] > curr_max){
                curr_max = A[i];
            }
            if(i == curr_max){
                part_num++;
            }
        }

        System.out.println(part_num);
    }
}
