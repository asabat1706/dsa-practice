public class IsPrime {
     public static void main(String[] args){
         int N = 100;  int count=0;
         for(int i=1; i<= Math.sqrt(N); i++)
         {
             if(N%i == 0) {
                 count = count+2;
             }
             if(count>2) {
                 System.out.println("NO");
                 break;
             }
         }
         if(count==2) System.out.println("YES");
     }
}
