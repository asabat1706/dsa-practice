package Stacks;

import java.util.Stack;

public class MinMaxSum {
    public static void main(String[] args) {
        int[] A = {994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066};
//        int[] A = {1};
        int mod = 1000000007;
        int[] nsel = new int[A.length];
        int[] nser = new int[A.length];

        int[] nmel = new int[A.length];
        int[] nmer = new int[A.length];

        Stack<Integer> indices = new Stack<>();
        nsel[0] = -1;
        indices.push(0);
        for (int i = 1; i < A.length; i++) {
            while (!indices.isEmpty() && A[i] <= A[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty())
                nsel[i] = -1;
            else nsel[i] = indices.peek();
            indices.push(i);
        }
        indices.clear();
        for (int i = A.length-1; i >= 0; i--)
        {
            while (!indices.isEmpty() && A[i] <= A[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty())
                nser[i] = A.length;
            else nser[i] = indices.peek();
            indices.push(i);
        }
        indices.clear();
        for (int i = 0; i < A.length; i++) {
            while (!indices.isEmpty() && A[i] >= A[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty())
                nmel[i] = -1;
            else nmel[i] = indices.peek();
            indices.push(i);
        }
        indices.clear();
        for (int i = A.length-1; i >= 0; i--)
        {
            while (!indices.isEmpty() && A[i] >= A[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty())
                nmer[i] = A.length;
            else nmer[i] = indices.peek();
            indices.push(i);
        }
//
//        for(int i=0; i<A.length; i++){
//            System.out.print(nsel[i] + "  ");
//        }
//        System.out.println("  ");
//        for(int i=0; i<A.length; i++){
//            System.out.print(nser[i] + "  ");
//        }
//        System.out.println("  ");
//        for(int i=0; i<A.length; i++){
//            System.out.print(nmel[i] + "  ");
//        }
//        System.out.println("  ");
//        for(int i=0; i<A.length; i++){
//            System.out.print(nmer[i] + "  ");
//        }
        long total_max = 0L;
        for(int i=0 ; i<A.length; i++){
            long l = (long) (i - nmel[i]) ;
            long r = (long) (nmer[i] - i);
            long cont = r * l;
            cont = ((cont % mod) * (A[i]%mod))%mod;
            total_max = ((total_max%mod) + (cont%mod))%mod;
        }

        long total_min = 0L;
        for(int i=0 ; i<A.length; i++){
            long l = i - nsel[i];
            long r = nser[i] - i;
            long cont = r * l;
            cont = ((cont % mod) * (A[i]%mod))%mod;
            total_min = ((total_min%mod) + (cont%mod))%mod;
        }
        int ans = (int) ((total_max - total_min)%mod);
        if(ans < 0) ans = ans+mod;
        System.out.println(ans);
    }
}
