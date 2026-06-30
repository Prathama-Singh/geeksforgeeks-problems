//https://www.geeksforgeeks.org/dsa/0-1-knapsack-problem-dp-10/
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][]mat = new int[n+1][W+1];
        // initialize(mat, n+1, W+1);
        
        for(int i = 0; i <= n; i++){
             for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0)
                    mat[i][j] = 0;
                else if(wt[i-1] <= j)
                    mat[i][j] = Math.max( (val[i-1] + mat[i-1][j-wt[i-1]]), mat[i-1][j]);
                else
                    mat[i][j] = mat[i-1][j];
            }
        }
        return mat[n][W];
    }
    
    void initialize( int[][]mat, int W, int n){
        for(int i = 0; i < W; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    mat[i][j] = 0;
                else
                    mat[i][j] = -1;
            }
        }
    }
}
