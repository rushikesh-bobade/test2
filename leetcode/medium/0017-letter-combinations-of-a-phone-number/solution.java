class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] phoneMap = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, new StringBuilder(), digits, 0, phoneMap);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current,
                           String digits, int index, String[] phoneMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1, phoneMap);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

