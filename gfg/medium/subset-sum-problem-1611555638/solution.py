class Solution:
    def isSubsetSum(self, arr, sum):
        dp = [False] * (sum + 1)
        dp[0] = True

        for num in arr:
            for target in range(sum, num - 1, -1):
                if dp[target - num]:
                    dp[target] = True

        return dp[sum]