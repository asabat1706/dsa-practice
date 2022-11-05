import java.util.Arrays;

public class Array101 {
    public static void main(String[] args)
    {
        int[] a = {2,6,4};

        System.out.println(findOcurrance(a));
    }

    private static int findOcurrance(int[] a) {
        Arrays.sort(a);
        System.out.println(a[a.length-1] + "---" +a[a.length-2]);
         return a[a.length-2];
    }


}
