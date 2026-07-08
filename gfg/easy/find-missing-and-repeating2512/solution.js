/**
 * @param {number[]} arr
 * @returns {number[]}
 */
class Solution {
    findTwoElement(arr) {
        const n = arr.length;

        let xorVal = 0;

        // XOR all array elements
        for (let num of arr) {
            xorVal ^= num;
        }

        // XOR numbers from 1 to n
        for (let i = 1; i <= n; i++) {
            xorVal ^= i;
        }

        // Get rightmost set bit
        let setBit = xorVal & -xorVal;

        let x = 0;
        let y = 0;

        // Divide array elements into two groups
        for (let num of arr) {
            if (num & setBit) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Divide numbers 1 to n into two groups
        for (let i = 1; i <= n; i++) {
            if (i & setBit) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // Find which is repeating and which is missing
        let count = 0;
        for (let num of arr) {
            if (num === x) count++;
        }

        if (count === 2) {
            return [x, y];
        } else {
            return [y, x];
        }
    }
}