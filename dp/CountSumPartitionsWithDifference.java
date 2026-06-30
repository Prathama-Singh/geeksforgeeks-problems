//https://www.geeksforgeeks.org/dsa/count-of-subsets-with-given-difference/
class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        int n = arr.length;
        for(int num : arr)
            sum+=num;
        if (diff > sum)
            return 0;
            
        int total = sum+diff;
        if (total % 2 != 0)
            return 0;

        return countSubsetSum(n, total/2, arr);
    }
    
    int countSubsetSum(int n, int sum, int[] arr){
        int [][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;

        for(int i = 1; i <= n ; i++){
            for(int j = 0; j <= sum ; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]]; 
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
