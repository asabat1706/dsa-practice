package DynamicProgramming;

public class MinimumSquareSum {
    static int[] memoization;
    public static void main(String[] args){
        int number = 6;
        memoization = new int[number+1];
        for(int i=0; i<=number; i++){
            memoization[i] = -1;
        }
        int min_squares = findMinSquares(number);
        System.out.println(min_squares);
    }

    private static int findMinSquares(int number) {
        if(number == 0){
            return 0;
        }
        if(memoization[number] != -1){
            return memoization[number];
        }
        int choices = (int) Math.sqrt(number);
        int min_steps = Integer.MAX_VALUE;
        for(int i=1; i<=choices; i++){
            int sum = i*i;
            int steps = findMinSquares(number - sum);
            min_steps = Math.min(steps,min_steps);
        }
        memoization[number] =  1+min_steps;
        return 1+min_steps;
    }
}
