class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes (e.g., -121 -> 121-)
        // Numbers ending in 0 (except 0 itself) cannot be palindromes (e.g., 10 -> 01)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        
        // Reversing only the second half of the integer
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When length is odd, we can get rid of the middle digit by reversedHalf / 10
        // For example, when input is 12321, at the end of the loop: x = 12, reversedHalf = 123
        return x == reversedHalf || x == reversedHalf / 10;
    }
}