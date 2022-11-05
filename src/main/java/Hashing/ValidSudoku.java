package Hashing;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args){
        String[] A={ "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
//        String[] A = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        int i = validateSudoku(A);
        System.out.println(i);
    }

    private static int validateSudoku(String[] A) {
        //        validate rows
        for(int row=0; row<9; row++){
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int col=0; col<9; col++){
                if((A[row].charAt(col)!='.') && (!hm.containsKey(A[row].charAt(col)))){
                    hm.put(A[row].charAt(col),1);
                }
                else if(A[row].charAt(col)=='.') continue;
                else return 0;
            }
        }
        System.out.println("rows validated");
//        validate cols
        for(int col=0; col<9; col++){
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int row=0; row<9; row++){
                if((A[row].charAt(col)!='.') && (!hm.containsKey(A[row].charAt(col))))
                    hm.put(A[row].charAt(col),1);
                else if(A[row].charAt(col)=='.') continue;
                else
                    return 0;
            }
        }
//        System.out.println("cols validated");

//        validate grids
        HashSet<Character> hs1 = null;
        HashSet<Character> hs2 = null;
        HashSet<Character> hs3 = null;
        for(int row=0; row<9; row++){
            if(row==0 || row==3 || row==6) {
                hs1 = new HashSet<>();
                hs2 = new HashSet<>();
                hs3 = new HashSet<>();
            }
            for(int col=0; col<9; col++){
               int grid_col=0;
                if(col < 3) grid_col=1;
                else if(col>=3 && col<6) grid_col=2;
                else grid_col=3;
                   if(grid_col==1) {
                       if ((A[row].charAt(col) != '.') && (!hs1.contains(A[row].charAt(col))))
                           hs1.add(A[row].charAt(col));
                       else if (A[row].charAt(col) == '.') continue;
                       else return 0;
                   }
                   if(grid_col==2) {
                       if ((A[row].charAt(col) != '.') && (!hs2.contains(A[row].charAt(col))))
                           hs2.add(A[row].charAt(col));
                       else if (A[row].charAt(col) == '.') continue;
                       else return 0;
                   }
                   if(grid_col==3) {
                       if ((A[row].charAt(col) != '.') && (!hs3.contains(A[row].charAt(col))))
                           hs3.add(A[row].charAt(col));
                       else if (A[row].charAt(col) == '.') continue;
                       else return 0;
                   }
            }
        }
        return 1;
    }
}
