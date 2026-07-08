func lengthOfLongestSubstring(s string) int {
    charIndex := make(map[byte]int)
    left := 0
    maxLength := 0

    for right := 0; right < len(s); right++ {
        if index, found := charIndex[s[right]]; found && index >= left {
            left = index + 1
        }

        charIndex[s[right]] = right

        if right-left+1 > maxLength {
            maxLength = right - left + 1
        }
    }

    return maxLength
}