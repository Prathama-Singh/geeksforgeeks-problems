//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
class Solution {
    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < n; i++)
            sum+=arr[i];
            
        boolean dp[][] = findSubsetSum(n, arr, sum);
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i <= sum/2; i++)
            if(dp[n][i])
                min = Math.min(min, sum-2*i);
        return min;
    }
    
    boolean[][] findSubsetSum(int n, int[] arr, int sum){
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i = 1 ; i <= sum; i++)
            dp[0][i] = false;
            
        for(int i = 0 ; i <= n; i++)
            dp[i][0] = true;
        
        for(int i = 1 ; i <= n; i++){
            for(int j = 1 ; j <= sum; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];    
            }
        }
        return dp;
    }
}
