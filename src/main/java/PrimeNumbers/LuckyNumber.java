package PrimeNumbers;

public class LuckyNumber {
    public static void main(String[] args){
        int A=12;
        int[] countfacts = new int[A+1];
        for(int i=0; i<countfacts.length; i++){
            countfacts[i]=i;
        }
        for(int i=2; i<=A; i++){
            if(countfacts[i] == i){
                for(int j=2*i; j<=A; j+=i){
                    if(countfacts[j]==j)
                        countfacts[j]=1;
                    else countfacts[j]++;
                }
            }
        }
        int ans=0;
        for(int i=0; i<countfacts.length; i++){
            if(countfacts[i] != i && countfacts[i]==2)
                ans++;
        }
        System.out.println(ans);
    }
}
