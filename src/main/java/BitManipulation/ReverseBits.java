package BitManipulation;

public class ReverseBits {
    public static void main(String[] args){
        int num = 3; int count=0;
        String binary="";
        while(num>=1){
            int d = num%2;
            binary = d+binary;
            num = num/2;
        }
        while(binary.length()<32){
            binary="0"+binary;
        }
        long sum=0;
        for(int i=0; i<binary.length();i++){
            double base = Math.pow(2,i);
            long base1 = (long) base;
            sum = sum+(Integer.parseInt(String.valueOf(binary.charAt(i)))*base1);
        }
        System.out.println(binary +" --- "+ binary.length()+ " --- "+ sum);
    }
}
