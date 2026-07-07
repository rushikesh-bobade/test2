/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */
class Solution {
    longestSubarray(arr, k) {
        let map = new Map();
        let sum = 0;
        let maxLen = 0;

        for (let i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Subarray from index 0 to i
            if (sum === k) {
                maxLen = i + 1;
            }

            // Check if prefix sum (sum - k) exists
            if (map.has(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store first occurrence only
            if (!map.has(sum)) {
                map.set(sum, i);
            }
        }

        return maxLen;
    }
}