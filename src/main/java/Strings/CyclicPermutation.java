package Strings;

public class CyclicPermutation {
    public static void main(String[] args){
        String A="111";
        String B="111";
        int N = B.length();
        int ans=0;
        String b_array = B;
           b_array = B + B.substring(0,N-1);
           b_array = A + "#" +b_array;
            System.out.println(b_array);
            int[] z_array = createZArray(b_array.toCharArray());
            for(int i=A.length(); i<z_array.length; i++){
                if (z_array[i]==N) {
                    ans++;
                }
            }

        System.out.println(ans);
    }

    private static int[] createZArray(char[] char_array) {
        int[] z = new int[char_array.length];
        z[0] = char_array.length;
        int s = 0, e = 0;
        for (int i = 1; i < char_array.length; i++) {
            if (i > e) {
                s = i;
                e = i;
                while ((e< char_array.length) && char_array[e] == char_array[e - s]) {
                    e++;
                }
                z[i] = e-s;
                e--;
            } else {
                if (z[i - s] < e-i+1) {
                    z[i] = z[i - s];
                } else {
                    s = i;
                    while ((e<char_array.length) && (char_array[e] == char_array[e - s])) {
                        e++;
                    }
                    z[i] = e-s;
                    e--;
                }
            }
        }
        return z;
    }
}
