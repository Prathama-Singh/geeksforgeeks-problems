//https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
class Solution {
    static boolean equalPartition(int arr[]) {
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++)
            sum+=arr[i];

        if(sum%2 != 0)
            return false;
        int sumToCheck = sum/2;
        
        boolean [][]dp = new boolean[n+1][sumToCheck+1];
        
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
        for(int i = 1; i <= sumToCheck; i++)
            dp[0][i] = false;
            
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sumToCheck; j++){
                if(arr[i-1] <= j ){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sumToCheck];
    }
}
