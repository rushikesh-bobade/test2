/**
 * @param {number[]} arr
 * @returns {number}
 */
class Solution {
    missingNumber(arr) {
        let n = arr.length;

        // Place each positive number x at index x-1
        for (let i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] !== arr[i]) {
                let temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the first index where value is not i+1
        for (let i = 0; i < n; i++) {
            if (arr[i] !== i + 1) {
                return i + 1;
            }
        }

        // All numbers from 1 to n are present
        return n + 1;
    }
}