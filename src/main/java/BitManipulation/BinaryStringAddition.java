package BitManipulation;

public class BinaryStringAddition {
    public static void main(String[] args){
        String a = "100";
        String b = "111";
        if(a.length() < b.length()){
            int diff = b.length()-a.length();
            while(diff>0){
                a = "0"+a;
                diff--;
            }
        }
        else if(b.length() < a.length()){
            int diff = a.length()-b.length();
            while(diff>0){
                b = "0"+b;
                diff--;
            }
        }
        int i = a.length()-1; int carry=0; String final_str= "";
        while(i>=0){
            int n1 = Character.getNumericValue(a.charAt(i));
            int n2 = Character.getNumericValue(b.charAt(i));
            int sum = n1+n2+carry;
            final_str = (sum%2)+final_str;
            carry = sum/2;
            i--;
        }
        if(carry!=0) final_str = "1"+final_str;
        System.out.println(final_str);
    }
}
