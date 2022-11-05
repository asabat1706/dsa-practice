package DynamicProgramming;

import java.net.Inet4Address;

public class DungeonPrincess {
    public static void main(String[] args){
//         int[][] input = {{1,-1,0},
//                          {-1,1,-1},
//                          {1, 0, -1}};
//         int[][] input = {{-39, -65, -93, -51, -97, -46, -32, -89, -70, -56, -14, -95, 2, -3, -32, -7, 8, -10, -16, -92},
//        {-95, -55, -99, -51, -7, -82, -93, -6, -8, -54, -76, -20, -80, -2, 9, -100, -81, -78, -58, -27},
//        {-76, -44, -40, -47, -50, -82, -21, -98, -28, 0, -10, 2, -90, -6, -12, -91, -28, -98, 1, -49},
//        {-18, -54, -95, -51, 8, -18, -33, -18, -44, 2, 3, -11, -81, -35, 7, -19, -82, -42, -21, -45},
//        {-57, -63, -42, -70, -66, -65, -52, -81, -17, -23, -91, 1, -68, -52, -42, 1, -65, -43, -69, -18},
//        {-57, -49, -35, -56, -20, -36, -42, -47, -70, -26, -53, -41, -9, -98, 2, -25, 8, -6, -99, -47},
//        {-76, -64, -8, -18, -3, 9, -23, -6, -93, -43, -82, -82, -47, -30, -48, -2, -54, -6, -19, -47},
//        {-4, -96, -28, 10, -95, -25, -29, -37, 4, -87, -58, -68, -7, -92, -34, -48, -21, -17, -55, -91},
//        {-28, -8, 5, -96, -17, -56, -54, -79, -17, 8, -92, -20, -65, -96, -88, -87, 6, -68, -46, -1},
//        {-25, -79, -27, -77, -88, 7, -70, 3, -10, -58, 10, 6, 5, -55, -94, -41, -26, -19, -39, -12},
//        {-46, -92, 9, -90, -31, -86, -1, 4, -40, -41, -95, 1, -60, -69, -42, -67, -45, -65, -47, -91},
//        {-32, -99, 4, -65, -10, -83, -67, -96, -69, -63, 4, -43, -48, -98, -16, -73, -21, 1, -81, -56},
//        {0, -1, -86, -71, -75, -1, -95, -22, -12, -38, -39, 10, -98, -53, -84, -60, -42, -85, -21, -98},
//        {-33, -6, -31, -66, -70, -27, -25, -99, -26, 8, -86, -68, -92, -63, -62, -95, -8, -65, -13, -31},
//        {-7, -84, -17, -66, -84, -13, 2, -34, -22, -96, -81, -89, -61, -34, 10, -23, -96, 3, -2, -82},
//        {-30, -48, 1, -40, -84, -7, -8, -90, -32, -5, 7, -53, -64, -25, -73, -82, -85, -40, 1, -35},
//        {-80, -83, -91, -90, -73, 2, -18, -25, -76, -72, -6, -28, -49, -86, 3, -80, -63, 4, -85, 3},
//        {6, -8, -52, 1, -57, -72, -73, -28, -88, -74, -25, -46, -93, -76, -10, -44, -92, -38, -70, -74},
//        {-43, -24, -98, -36, -77, -81, -2, -90, 1, -42, 3, -82, -2, -32, -80, -32, -12, -60, -79, -32},
//        {-91, -82, -65, 8, -12, -64, -42, -82, -66, -16, -97, -96, -79, -29, -79, -6, -6, -19, 3, 4}
//};

         int[][] input = {
                 {-71, -63, -86, -48, -56, -73, -20, -37, -86, -99, 6, -29, -61, -35, -86, -91, -90, -52, -53, -2},
                 {-56, -94, -21, -63, -42, -81, -65, -29, -61, 2, -36, -89, -2, -42, -15, -43, -100, -29, -17, 8},
                 {-34, -39, -3, -76, -28, -33, 3, -58, -26, -49, -52, -88, -98, -96, -65, -95, -81, -10, -43, -11},
                 {-33, -72, 6, -50, -25, -30, -49, -29, -1, -30, -97, -34, -4, -81, -95, -78, -64, -17, -14, 8},
                 {-19, -95, -46, -38, -26, -5, -93, 5, -41, -77, -29, -89, -10, -52, -42, -69, -95, -85, -77, -44},
                 {-14, -91, -63, -58, 2, -70, -63, -27, -60, -50, -16, -38, -16, -6, -66, 3, -45, -83, -100, -91},
                 {-100, -39, -53, -35, -20, -43, -19, 5, -73, -22, 2, 2, -64, -44, -88, -26, 1, -62, -14, -11},
                 {-27, -94, -56, -15, -84, -88, -34, 10, -41, -13, -51, -13, -63, -72, -12, -5, -6, -28, -52, -5},
                 {-96, -21, -30, -67, -18, -62, -94, -6, -61, 5, -5, -55, -8, -25, -34, -49, -39, -19, -15, -67},
                 {-26, -32, -43, -13, -57, -11, -38, -41, -42, -57, -30, -63, -26, -43, -17, -32, -48, -45, -62, -37},
                 {-81, -79, 7, -62, -22, -46, -36, -100, -24, -6, -28, -31, -81, -5, -84, -67, -24, 10, -52, -19},
                 {-11, -64, -90, -82, -73, -26, -33, -6, 0, -24, -96, 6, -81, -10, -79, -72, -72, -17, 2, -90},
                 {-65, -62, -36, -26, -41, -12, -82, -52, -87, -2, -43, -90, -50, 3, -20, -90, -51, 5, -28, -77},
                 {-8, -75, -32, -36, -83, -82, -77, 6, -29, 8, -67, -26, -100, -41, -36, -83, -12, -63, -79, -93},
                 {-53, 5, -50, -69, -20, -41, -72, -64, -37, 7, -51, -15, -74, -81, -58, -49, 3, -27, -46, -17},
                 {-74, -44, -65, -24, -66, -98, 3, -35, -67, -92, -47, -73, -44, -49, 8, -57, -11, 5, -69, -40},
                 {-29, -79, -67, -71, -29, -54, -86, -87, -6, -76, 3, 3, -14, -93, -86, -95, -95, -52, -15, -9},
                 {-87, -86, -32, 4, -21, -67, 10, -90, -55, -64, -39, -2, -42, -51, -51, 9, -27, -83, -79, 5},
                 {-85, -73, -51, -60, -85, -84, -65, -49, 4, -30, -19, -23, -68, -99, -18, -99, -52, -10, -87, 5},
                 {-69, -4, -8, -69, -44, -33, -62, -27, -41, -68, -26, -80, -50, -53, -52, -39, -86, -23, -25, -9}
         };
         int n = input.length;
         int m = input[0].length;
         int[][] min_health = new int[n+1][m+1];

         for(int i=0; i<=n; i++){
             for(int j=0; j<=m; j++){
                 if(i==n || j==m){
                    min_health[i][j] = Integer.MAX_VALUE;
                 }
             }
         }

         int last_health = input[n-1][m-1];
         int health = Math.max(1, ( 1 - last_health));

         min_health[n-1][m-1] = health;
         for(int row= n-1; row>=0; row--){
             for(int col=m-1; col>=0; col--){
                 if((row == n-1) && (col == m-1)) {
                     continue;
                 }
                 health = Math.min(min_health[row][col+1], min_health[row+1][col]) - input[row][col];
                 min_health[row][col] = Math.max(1,health);
             }
         }
        System.out.println(min_health[0][0]);
    }
}