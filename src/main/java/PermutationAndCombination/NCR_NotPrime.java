package PermutationAndCombination;

public class NCR_NotPrime {
    public static void main(String[] args){
        int A=51299, B=25646, C=3685739;
        int[][] selectionMat = new int[A+1][B+1];
        for(int i=0; i<=A; i++){
            for(int j=0; j<=Math.min(i,B); j++){
                if(j==0 || j==i)
                    selectionMat[i][j]=1;
                else
                    selectionMat[i][j] = ((selectionMat[i-1][j-1]%C) + (selectionMat[i-1][j]%C))%C;
            }
        }
        System.out.println(selectionMat[A][B]%C);
    }


}
