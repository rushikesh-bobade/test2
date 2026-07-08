class Solution {
  public:
    int maxLength(vector<int>& arr) {
        unordered_map<int, int> firstIndex;
        
        int sum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
            
            // If prefix sum is 0, subarray from 0 to i has sum 0
            if (sum == 0) {
                maxLen = i + 1;
            }
            
            // If this sum was seen before, the elements between have sum 0
            if (firstIndex.find(sum) != firstIndex.end()) {
                maxLen = max(maxLen, i - firstIndex[sum]);
            } else {
                firstIndex[sum] = i;
            }
        }
        
        return maxLen;
    }
};