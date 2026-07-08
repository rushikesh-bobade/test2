class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int target = sum; target >= num; target--) {
                if (dp[target - num]) {
                    dp[target] = true;
                }
            }
        }

        return dp[sum];
    }
}