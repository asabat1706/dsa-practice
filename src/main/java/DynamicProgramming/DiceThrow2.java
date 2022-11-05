package DynamicProgramming;

public class DiceThrow2 {
    static int[] DP;
    public static void main(String[] args){
        int input = 4;
        DP = new int[input+1];
        DP[1] = 1;
        int ways=0;
        for(int i=1; i<input ; i++){
           if(DP[i] != 0){
               ways += DP[i];
           }
           else{
               int interim_ways=0;
               for(int j=1; j<i; j++){
                   interim_ways += DP[j];
               }
               DP[i] = interim_ways + 1;
               ways += DP[i];
           }
        }
        DP[input] = ways +1;
        System.out.println(DP[input]);
    }


}
