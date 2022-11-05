package InterviewProblems;

import java.util.*;

public class RowColumnZero {
      public static void main(String[] args){
        int A[][]= {{1,2,3,4},{5,6,7,0},{9,2,0,4}};
        int B[][] = A;
        Set<Integer> l_row = new HashSet<>();
        Set<Integer> l_col = new HashSet<>();

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j]==0){
                    l_col.add(j);
                    l_row.add(i);
                }
            }
        }
          for (Integer integer : l_row) {
              int t = integer;
              for (int j = 0; j < A[0].length; j++) {
                  A[t][j] = 0;
              }
          }
          for (Integer integer : l_col) {
              int t = integer;
              for (int i = 0; i < A.length; i++) {
                  A[i][t] = 0;
              }
          }
          for(int i=0; i<A.length; i++){
              for(int j=0; j<A[0].length; j++){
                  System.out.print(B[i][j]);
              }
              System.out.println(" ");
          }

    }
}
