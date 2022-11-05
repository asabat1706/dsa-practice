package Strings;

public class CountOccurrences {
    public static void main(String[] args){
        String A="bobob"; int count=0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='b'){
                if((i+2)<A.length())
                if(A.charAt(i+1)=='o' && A.charAt(i+2)=='b') {
                    count++;
                    i++;
                }
            }
        }
        System.out.println(count);
    }
}
