package Strings;

public class StringOps {
    public static void main(String[] args){
        String A="lLdfRVCgbkND";
        StringBuilder sb = new StringBuilder(A);
        int len = A.length();
        for(int i=0; i<len;i++){
            if(sb.charAt(i)>='A' && sb.charAt(i)<='Z'){
                sb.deleteCharAt(i);
                len--;
                i--;
            }
        }
        System.out.println(sb);
        for(int i=0; i<len;i++){
            if(sb.charAt(i)=='a' || sb.charAt(i)=='e' || sb.charAt(i)=='i'
            ||sb.charAt(i)=='o' || sb.charAt(i)=='u'){
                sb.replace(i,i+1,"#");
            }
        }
        sb.append(sb);
        System.out.println(sb.toString());
    }
}
