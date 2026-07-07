import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int needed = target - num;

            if (seen.contains(needed)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }
}