package Hashing;

import java.util.HashMap;
import java.util.Stack;

public class LexicographicCheck {
    public static void main(String[] args){
//        String[] A ={"ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow"};
//        String B="nbpfhmirzqxsjwdoveuacykltg";
//        String[] A={"fine", "none", "no"};
//        String B="qwertyuiopasdfghjklzxcvbnm";
        String[] A={"hello", "scaler", "interviewbit"};
        String B="adhbcfegskjlponmirqtxwuvzy";
        int i = solve(A,B);
        System.out.println(i);
    }

    private static int solve(String[] A, String B) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int last_index = -1;
        for(int i=0; i<B.length(); i++){
            hm.put(B.charAt(i),i);
        }
        for(int i=0; i<A.length; i++){
            char ch = A[i].charAt(0);
            if(hm.containsKey(ch)) {
                int index = hm.get(ch);
                if (index > last_index)
                    last_index = index;
                else if (index < last_index)
                    return 0;
                else {
                    String s1 = A[i - 1];
                    String s2 = A[i];
                    if (s1.length() > s2.length())
                        return 0;
                    else if (s1.length() <= s2.length()) {
                        int min_length = Math.min(s1.length(), s2.length());
                        int j = 1;
                        while (j < min_length) {
                            int index1 = hm.get(s1.charAt(j));
                            int index2 = hm.get(s2.charAt(j));
                            if (index1 > index2) return 0;
                            if (index1 < index2) break;
                            else j++;
                        }
                    }
                }
              }
            }
        return 1;
    }
}
