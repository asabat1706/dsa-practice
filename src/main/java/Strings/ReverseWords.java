package Strings;

public class ReverseWords {
    public static void main(String[] args){
        String A = "The sky is blue";
        A.trim();
        int last_space_index=-1;
        A = reverse(A,0,A.length());
        int k;
        for(k=0; k<A.length(); k++){
            if(A.charAt(k)==' ') {
                int index = A.indexOf(' ');
                if (k == index) {
                    A = reverse(A, 0, k);
                    last_space_index = k;
                } else {
                    A = reverse(A, last_space_index+1, k);
                    last_space_index = k;
                }
            }
        }
        A = reverse(A,last_space_index+1,A.length());
        System.out.println(A);
    }

    private static String reverse(String a, int s, int e) {
        char[] temp = a.toCharArray();
        int p = e+s;
        for(int i=s; i<p/2; i++){
            char temp1 = a.charAt(p-1-i);
            char temp2 = a.charAt(i);
            temp[i] = temp1; temp[p-1-i]=temp2;
        }
        a = new String(temp);
        return a;
    }
}
