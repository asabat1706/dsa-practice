package DSCarryForward;

public class AGSequence {
    public static void main(String[] args){
        String str="ABCEGUTAGGWG";
        int a_count=0, string_count=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='A')
                a_count++;
            else if(str.charAt(i)=='G')
                string_count = string_count+a_count;
        }
        System.out.println("count "+string_count);
    }
}
