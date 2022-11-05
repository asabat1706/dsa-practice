public class LeftRotate {
    public static void main(String[] args) {
        int a[] = { 6, 31, 33, 13, 82, 66, 9, 12, 69, 21, 17, 2, 50, 69, 90, 71, 31, 1, 13, 70, 94, 46, 89, 13, 55, 54, 67, 97, 28, 27, 62, 34, 41, 18, 15, 35, 13, 84, 93, 27, 89, 23, 6, 56, 94, 40, 54, 95, 47 };
        int b[] = { 88, 85, 98, 36, 66, 40, 30, 26, 51, 77, 62, 60, 92, 64, 53, 86, 24, 53, 85, 49, 57, 29, 32, 60, 75, 82, 17, 23, 67, 51, 23, 11, 70, 59 };
        int c[][] = new int[b.length][a.length];
        for (int j = 0; j < b.length; j++){
            for(int i=0; i<a.length; i++){
               int t = (i-b[j])%a.length;
               if(t<0) t = a.length + t;
               c[j][t] = a[i];
            }
        }
//        for (int j = 0; j < b.length; j++){
//            for(int i=0; i<a.length; i++){
//                System.out.print(c[j][i]);
//            }
//            System.out.println("");
//        }
    }
}
