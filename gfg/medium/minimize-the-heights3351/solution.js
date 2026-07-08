/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */

class Solution {
    getMinDiff(arr, k) {
        arr.sort((a, b) => a - b);

        const n = arr.length;
        let ans = arr[n - 1] - arr[0];

        for (let i = 1; i < n; i++) {
            // Skip if height becomes negative
            if (arr[i] - k < 0) continue;

            const mini = Math.min(arr[0] + k, arr[i] - k);
            const maxi = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, maxi - mini);
        }

        return ans;
    }
}