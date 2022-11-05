package BitManipulation;

public class InterestingArray {
    public static void main(String[] args){
        int count=0; int A=5;
        while(A>0){
            if(!((A&1)==0))
                count = count+1;
            A=A/2;
        }
        System.out.println(count);
        System.out.println(3^6);
    }
}
