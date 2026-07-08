class Solution:
    def findTwoElement(self, arr):
        n = len(arr)

        xor_val = 0

        # XOR all array elements and numbers from 1 to n
        for num in arr:
            xor_val ^= num

        for i in range(1, n + 1):
            xor_val ^= i

        # Find rightmost set bit
        set_bit = xor_val & -xor_val

        x = 0
        y = 0

        # Divide numbers into two groups
        for num in arr:
            if num & set_bit:
                x ^= num
            else:
                y ^= num

        for i in range(1, n + 1):
            if i & set_bit:
                x ^= i
            else:
                y ^= i

        # Determine which one is repeating
        if x in arr:
            return [x, y]
        else:
            return [y, x]