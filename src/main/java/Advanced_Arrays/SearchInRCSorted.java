package Advanced_Arrays;

public class SearchInRCSorted {
    public static void main(String[] args){
        int[][] A = {{2,8,8,8},
                {2,8,8,8},
                {2,8,8,8}};
        int B = 8; int ans= Integer.MIN_VALUE; boolean found=false;
        int row=0, col=A[0].length-1;
        while(col>=0 && row<A.length){
            if(B < A[row][col])
                col--;
            else if(B > A[row][col]){
                row++;
            }
            else {
                ans = Math.min(ans,((row+1)*1009)+(col+1));
                found=true;
                col--;
            }
        }
        if(found==false) ans=-1;
        System.out.println(ans);
    }
}
