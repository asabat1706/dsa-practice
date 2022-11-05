package Searching;

public class MatrixSearch {
    public static void main(String[] args){
        int[][] A = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int B = 34;
        int index = binarySearchMatrix(A,B);
        System.out.println(index);
    }

    private static int binarySearchMatrix(int[][] A, int B) {
        int start_row = 0, end_row = A.length - 1;
        int max_col = A[0].length - 1;
        while (start_row <= end_row) {
            int mid_row = (end_row + start_row) / 2;
            if (A[mid_row][max_col] == B) {
                return 1;
            } else if (A[mid_row][max_col] > B) {
                if (A[mid_row][0] > B) {
                    end_row = mid_row - 1;
                } else {
                    int start_col = 0, end_col = max_col;
                    while (start_col <= end_col) {
                        int mid_col = (start_col + end_col) / 2;
                        if (A[mid_row][mid_col] == B) {
                            return 1;
                        } else if (A[mid_row][mid_col] > B) {
                            end_col = mid_col - 1;
                        } else {
                            start_col = mid_col + 1;
                        }
                    }
                    break;
                }
            } else {
                start_row = mid_row + 1;
            }
        }
        return -1;
    }

}