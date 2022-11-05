package Matrices;

public class RotateMatrix {
    public static void main(String[] args) {
        int A[][] = {{1, 2}, {3,4}};
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[0].length / 2); j++) {
                int n = A[0].length;
                int temp = A[i][j];
                A[i][j] = A[i][(n-1)- j];
                A[i][(n-1) - j] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }


    }
}
