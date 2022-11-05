package Searching;

public class MatrixMedian3 {
    public static void main(String[] args){

    }
    public int findMedian(int[][] A) {

        int no_of_row = A.length;
        int no_of_col = A[0].length;
        int high = A[0][no_of_col-1];
        int low = A[0][0];
        int ans = 0;
        for(int i=0; i<no_of_row; i++)
        {
            if(low > A[i][0])
                low = A[i][0];
        }
        for(int i=0; i<no_of_row; i++)
        {
            if(high < A[i][no_of_col-1])
                high = A[i][no_of_col-1];
        }
        int medium = ((no_of_row*no_of_col)>>1)+1;
        while(low<=high)
        {
            int mid = (low+high)>>1;
            int count = 0;
            for(int i=0; i<no_of_row; i++)
            {
                count += binarySearch(A, i, 0, no_of_col-1, mid);
            }
            if(count < medium)
                low = mid+1;
            else
            {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    int binarySearch(int[][] A, int row_no, int start, int end, int target)
    {
        int count = 0;
        while(start<=end)
        {
            int mid = (start+end)>>1;
            if(A[row_no][mid] <= target)
            {
                count = mid+1;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return count;
    }
}
