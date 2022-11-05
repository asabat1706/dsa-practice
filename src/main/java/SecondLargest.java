import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args){
        int a[] = {1,2,3,4};
        Arrays.sort(a);
        System.out.println(a[a.length-2]);
    }
}
