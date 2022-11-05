package ModularArithmetic;

public class OverlappingRectangles {
    public static void main(String[] args){
        int A=-175, B=17, C=340, D=349, E=-118, F=-426, G=355, H=17;
        int num=0;
        if(B < F){
        if(((B-F)<0&&(D-F)>0) || ((B-H)<0&&(D-H)>0)) {
            if(A < E) {
                if (((A - E)<0 && (C - E) >0) || ((A - G)<0 && (C - G) > 0)) {
                    num = 1;
                }
            }
            else{
                if (((E - A)<0 && (G - A) > 0) || ((E - C)<0 && (G - C) > 0)) {
                    num = 1;
                }
            }
        }}
        else{
            if(((F-B)<0 &&(H-B)>0) || ((F-D)<0 &&(H-D)>0)) {
                if (A < E) {
                    if (((A - E)<0 && (C - E) > 0) || ((A - G)<0 && (C - G) > 0)) {
                        num = 1;
                    }
                } else {
                    if (((E - A)<0 && (G - A) > 0) || ((E - C)<0 && (G - C) > 0)) {
                        num = 1;
                    }
                }
            }
        }
        System.out.println(num);
    }
}
