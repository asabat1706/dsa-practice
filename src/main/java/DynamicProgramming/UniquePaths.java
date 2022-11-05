package DynamicProgramming;

public class UniquePaths {
    public static void main(String[] args){
        int[][] input = {{0,0,0},
                {0,1,0},
                {0,0,0}};
        int n = input.length;
        int m = input[0].length;
        int[][] paths = new int[n+1][m+1];
        paths[1][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if((i==1) && (j==0)){
                    continue;
                }
                if(input[i-1][j-1] == 1){
                    paths[i][j] = 0;
                    continue;
                }
                paths[i][j] = paths[i][j-1] + paths[i-1][j];
            }
        }

        System.out.println(paths[n][m]);
    }
}
