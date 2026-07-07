class Solution {
  public:
    bool twoSum(vector<int>& arr, int target) {
        unordered_set<int> seen;

        for (int num : arr) {
            int needed = target - num;

            if (seen.find(needed) != seen.end()) {
                return true;
            }

            seen.insert(num);
        }

        return false;
    }
};