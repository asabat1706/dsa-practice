package InterviewProblems;

public class HaloDiamond1 {
    public static void main(String[] args){
        int N=3;
        int A[][] = new int[2*N][2*N];
        for(int col=0 ; col<N; col++){
            int star_count = N-col;
            for(int row=0; row<N; row++){
               if(star_count >0) {
                   A[row][col] = 1;
                   star_count--;
               }
               else System.out.print("");
            }
        }
        for(int col=N ; col<2*N; col++){
            int star_count = (col+1)-N;
            for(int row=0; row<N; row++){
                if(star_count >0) {
                    A[row][col] = 1;
                    star_count--;
                }
                else System.out.print("");
            }
        }
        for(int col=0 ; col<N; col++){
            int star_count = N-col;
            for(int row=2*N-1; row>=N; row--){
                if(star_count >0) {
                    A[row][col] = 1;
                    star_count--;
                }
                else System.out.print("");
            }
        }
        for(int col=N ; col<2*N; col++){
            int star_count = col+1-N;
            for(int row=2*N-1; row>=N; row--){
                if(star_count >0) {
                    A[row][col] = 1;
                    star_count--;
                }
                else System.out.print("");
            }
        }
        for(int i=0; i< 2*N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if(A[i][j]==1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
