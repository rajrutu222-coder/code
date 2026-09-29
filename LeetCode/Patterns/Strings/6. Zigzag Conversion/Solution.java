class Solution {
    public String convert(String s, int numRows) {
        // Base case: if numRows is 1 or string length is less than or equal to numRows, no conversion is needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Reverse direction when reaching the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}