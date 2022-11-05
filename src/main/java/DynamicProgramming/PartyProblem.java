package DynamicProgramming;

public class PartyProblem {
    public static void main(String[] args){
        int number_of_people = 1;
        int mod = 10003;
        long[] party_memo = new long[number_of_people+1];
        party_memo[0] = 0;
        party_memo[1] = 1;
        party_memo[2] = 2;
        for(int i=3; i<= number_of_people; i++)
        {
            long party_alone = party_memo[i - 1];
            long party_pair = (i - 1) * party_memo[i - 2];
            party_memo[i] = (((party_alone%mod)+(party_pair%mod))%mod);
        }
        System.out.println((int)(party_memo[number_of_people]%mod));
    }
}
