class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length) {
            return s
        }

        val rows = Array(numRows) { StringBuilder() }

        var currentRow = 0
        var direction = -1

        for (ch in s) {
            rows[currentRow].append(ch)

            // Change direction at top and bottom rows
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction *= -1
            }

            currentRow += direction
        }

        val result = StringBuilder()

        for (row in rows) {
            result.append(row)
        }

        return result.toString()
    }
}