package InterviewProblems;

public class ReverseHaloTriangle {
    public static void main(String[] args){
        int N=4;
        int A[][] = new int[N][N];
        for(int i=0; i< A.length; i++){
            A[i][0] = 1;
            A[0][i] = 1;
        }
        int j=N-2, i=1;
        while(j>=0){
            A[i][j]=1;
            j--;i++;
        }
         int L= A[0].length;
        for(int t=0; t<A.length; t++){
            for(int k=0; k<L; k++){
                if(A[t][k]==1) System.out.print("*");
                else System.out.print(" ");
            }
            L--;
            System.out.println("");
        }

    }
}
