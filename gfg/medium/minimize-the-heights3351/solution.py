class Solution:
    def getMinDiff(self, arr, k):
        arr.sort()
        n = len(arr)

        ans = arr[-1] - arr[0]

        for i in range(1, n):
            # Skip if height becomes negative
            if arr[i] - k < 0:
                continue

            mini = min(arr[0] + k, arr[i] - k)
            maxi = max(arr[i - 1] + k, arr[-1] - k)

            ans = min(ans, maxi - mini)

        return ans