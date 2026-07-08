class Solution:
    def maxLength(self, arr):
        prefix_sum = 0
        max_len = 0
        first_index = {}

        for i, num in enumerate(arr):
            prefix_sum += num

            # Subarray from index 0 to i has sum 0
            if prefix_sum == 0:
                max_len = i + 1

            # If prefix sum was seen before, the middle part has sum 0
            if prefix_sum in first_index:
                max_len = max(max_len, i - first_index[prefix_sum])
            else:
                first_index[prefix_sum] = i

        return max_len