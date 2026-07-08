class Solution {
    fun isPalindrome(x: Int): Boolean {
        // Negative numbers cannot be palindrome
        if (x < 0) return false
        
        // Numbers ending with 0 (except 0 itself) cannot be palindrome
        if (x % 10 == 0 && x != 0) return false
        
        var num = x
        var reversed = 0
        
        // Reverse only half of the number
        while (num > reversed) {
            reversed = reversed * 10 + num % 10
            num /= 10
        }
        
        // For even digits: num == reversed
        // For odd digits: num == reversed / 10 (middle digit ignored)
        return num == reversed || num == reversed / 10
    }
}