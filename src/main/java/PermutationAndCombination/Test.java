package PermutationAndCombination;

public class Test {
    public static void main(String[] args){
        int res = 1; String A ="baa"; int mod = 1000003;

        for (int i = 0; i < A.length(); i++) {

            int count = 0;

            //Count all the value less than current alpha

            for (int j = i + 1; j < A.length(); j++) {

                if (A.charAt(i) > A.charAt(j)) {

                    count++;

                }

            }

            //Find the freq of all the dup apha from the current element.

            int[] freq = new int[52];

            for (int j = i; j < A.length(); j++) {

                if (A.charAt(j) >= 'a' && A.charAt(j) <= 'z') {

                    freq[A.charAt(j) - 'a']++;

                } else {

                    freq[A.charAt(j) - 'A' + 26]++;

                }

            }

            long factVal = 1;

            //Take fact for the dup values

            for (int j =0; j < freq.length; j++) {

                if (freq[j] > 1) {

                    factVal = factVal * fact(freq[j]) % mod;

                }

            }

            //take Fermat mod on the total dup value

            long inverse = getFermatSolve(factVal, mod);



            res = (int) ((res % mod) + (count * fact(A.length() - 1 - i) * inverse) % mod);

        }
        System.out.println(res);
    }

    private static long getFermatSolve(long A, int B) {
        int mod = 1000003;
        int result = 1;

        long p = B - 2;

        long a = A;

        while (p > 0) {

            if (p % 2 == 1) {

                result = (int) ((result * a) % mod);

            }

            a = (a * a) % mod;

            p >>= 1;

        }

        return result;
    }

    private static int fact(int n) {
        int mod = 1000003;

        if (n > -1 && n < 2) {

            return 1;

        }

        int fact = 1;

        for (int i = 2; i <= n; i++) {

            fact = (fact * i) % mod;

        }

        return (fact % mod);
    }
}
