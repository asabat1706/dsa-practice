package PermutationAndCombination;

public class RankUniqueChars {
    public static void main(String[] args){
        String s = "acb"; int mod = 1000003;
        long rank = 0;
        for(int i=0; i<s.length(); i++){
            int count=0;
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i)> s.charAt(j))
                    count++;
            }
            long total_fact = ((count%mod) * (factorial(s.length()-1-i, mod)%mod))%mod;
            rank  = ((rank%mod) + (total_fact%mod))%mod;
        }
        System.out.println(rank+1);
    }

    private static long factorial(int n, int mod) {
        if(n==0) return 1%mod;
        else if(n==1) return 1%mod;
        else return ((n%mod) * (factorial(n-1,mod)%mod))%mod;
    }
}
