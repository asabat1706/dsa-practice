public class GoodPair {
    public static void main(String[] args){
        int a[] = {1,2,3,4};
        int b = 7;
        boolean istrue = false;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i]+a[j]==b) {
                    System.out.println(1);
                    istrue = true;
                }
            }
        }
        if(!istrue)
        System.out.println(0);
    }
}
