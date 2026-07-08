class Solution {
    areAnagrams(s1, s2) {
        if (s1.length !== s2.length) {
            return false;
        }

        const freq = new Array(26).fill(0);

        for (let ch of s1) {
            freq[ch.charCodeAt(0) - 97]++;
        }

        for (let ch of s2) {
            freq[ch.charCodeAt(0) - 97]--;
        }

        for (let count of freq) {
            if (count !== 0) {
                return false;
            }
        }

        return true;
    }
}