package SubArrays;

import java.util.ArrayList;

public class AltArray {
    public static void main(String[] args) {
        int A[] = {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
        int B = 1;
        B = 2 * B + 1;
        ArrayList<Integer> l = new ArrayList<>();
        for(int j=0; j<A.length-B; j++) {
            int s=j, e=s+B-1; int state= A[j]; boolean is_alt=true;
            for (int i = s; i <= e; i++) {
                if (A[i] == state) {
                    state = 1 - state;
                } else {
                    is_alt = false;
                    break;
                }
                if (i == e && is_alt) {
                    int t = e - (B - 1);
                    l.add((e + t) / 2);
                }
            }
        }
        System.out.println(l);
    }
}
