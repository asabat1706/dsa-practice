package Advanced_Arrays;

public class SortedBinaryMatrix {
    public static void main(String[] args){
        int[][] A = {{0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1}};
        int row=0; int col=0; int maxCount = Integer.MIN_VALUE; int index=Integer.MAX_VALUE;
        while(row < A.length && col < A[0].length){
            if(A[row][col]==0) {
                col++;
                if(col==A[0].length) {
                    row++;
                    col=0;
                }
            }
            else{
                int ones = A[0].length-col;
                if(ones > maxCount){
                    maxCount = ones;
                    index = row;
                }
                row++;
                col=0;
            }
        }
        System.out.println(index);
    }
}
